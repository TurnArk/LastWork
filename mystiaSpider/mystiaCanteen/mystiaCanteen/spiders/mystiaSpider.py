import json
import re

import scrapy
import time
import chardet
from scrapy import Selector
from selenium import webdriver
from scrapy_selenium import SeleniumRequest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC



class Message(scrapy.Item):
    id = scrapy.Field()
    name = scrapy.Field()
    description = scrapy.Field()
    url = scrapy.Field()    # 爬取内容的图片的路径
    tags = scrapy.Field()
    price = scrapy.Field()

class MystiaspiderSpider(scrapy.Spider):
    name = "mystiaSpider"
    allowed_domains = ["izakaya.cc"]
    start_urls = ["https://izakaya.cc/recipes",
                  "https://izakaya.cc/beverages",
                  "https://izakaya.cc/ingredients",
                  "https://izakaya.cc/cookers",]
    url_data = ['../Data/dish.csv',
                '../Data/drink.csv',
                '../Data/food.csv',
                '../Data/kitchenware.csv']

    def start_requests(self):
        for url in self.start_urls:
            yield SeleniumRequest(
                url=url,
                callback=self.parse,
                wait_time=10
            )

    def empty_delete(self,text,xpath_str):
        print("开始处理空白\n")
        data=text.xpath(xpath_str).get()
        if data is not None and data is not "":
            print("这个地方是确实有的并且要处理看看\n")
            return str(data).strip()
        # print("在 "+text.xpath('.').get()+" 下面，路径 "+xpath_str+" 没找到东西，草了")
        return ""


    def get_data_item(self,index,page_source,id_position=3):
        print("")
        item = Message()
        print(f'.//div[{index}]/p[{id_position}]/span[2]/text()')
        item['id'] = self.empty_delete(page_source,f'.//div[{index}]/p[{id_position}]/span[2]/text()')
        item['name'] = self.empty_delete(page_source, f'.//div[1]/p/text()')
        item['description'] = self.empty_delete(page_source, f'.//p[contains(@class, "break-all") and contains(@class, "text-justify")]/text()')
        # item['url'] = self.empty_delete(element, f'./div[1]/span[@style]')
        style_url=page_source.xpath(".//div[1]/span[@style]").get()
        if style_url:
            url_match=re.search(r'url\("(.*?)"\)',style_url)
            if url_match:
                item['url'] = url_match.group(1)
        item['price'] = self.empty_delete(page_source, f'.//div[{index}]/p[1]/span[2]/text()')
        context=page_source.xpath(f'.//div[{index+1}]')
        print(f'.//div[{index+1}]')
        if context:
            truly = []
            falsely = []
            list_t = context.xpath(f'.//span[contains(@class,"before:mr-1")]')
            list_f = context.xpath(f'.//span[contains(@class,"after:ml-0.5")]')
            if list_t:
                for tr in list_t:
                    truly.append(self.empty_delete(tr,f'./text()'))
            if list_f:
                for fa in list_f:
                    falsely.append(self.empty_delete(fa,f'./text()'))
            dist={
                "truly": truly,
                "falsely": falsely
            }
            item["tags"]=json.dumps(dist,ensure_ascii=False)
            return f"{item['id']},{item['name']},{item['url']},{item['description']},{item['price']},{item['tags']}"



    def write_data(self,page_source,index):
        time.sleep(1)
        print("开始处理对应部分并写入文件\n")
        # element=scrapy.Selector(text=page_source)
        # with open(self.url_data[index],'rb')as f:
        #     result = chardet.detect(f.read())
        #     encoding = result.get('encoding')
        file = open(self.url_data[index],'a+',encoding= 'utf-8')
        print("看看处理以后的内容正不正确:\n\n\n" + page_source.xpath('.').get() + "\n\n\n")
        if index == 0:
            data=self.get_data_item(3,page_source)
        elif index == 1 :
            data=self.get_data_item(2,page_source)
        elif index == 2 :
            data=self.get_data_item(2,page_source,4)
        else:
            item = Message()
            item['id'] = self.empty_delete(page_source, f'.//div[2]/p[2]/span[2]/text()')
            item['name'] = self.empty_delete(page_source, f'.//div[1]/p/text()')
            item['description'] = self.empty_delete(page_source, f'.//p[contains(@class, "break-all") and contains(@class, "text-justify")]/text()')
            style_url = page_source.xpath(".//div[1]/span[@style]").get()
            if style_url:
                url_match = re.search(r'url\("(.*?)"\)', style_url)
                if url_match:
                    item['url'] = url_match.group(1)
            item['price'] = self.empty_delete(page_source, f'.//div[3]/p/span[2]/span[2]/text()')
            data = f"{item['id']},{item['name']},{item['url']},{item['description']},{item['price']}"
        file.write(data+"\n")
        print("数据写进去了\n")
        file.close()

    def parse(self, response):
        driver = webdriver.Edge()
        driver.maximize_window()
        for i in range(0,4):
            driver.get(self.start_urls[i])
            print("获取页面成功\n")
            time.sleep(30)
            try:
                # t_list=scrapy.Selector(text=driver.page_source).xpath(".//main/div/button[@role='button']")
                t_list = driver.find_elements(By.XPATH,".//main/div/button[@role='button']")
                for button in t_list:
                    print("成功找到对应按钮并进入循环开始处理\n")
                    # scroll_by = button.location['y']  # 获取按钮位置
                    # driver.execute_script("window.scrollTo(0,arguments[0])", scroll_by)
                    time.sleep(1)
                    if button:
                        button.click()
                        print("点击按钮展开需要爬取的部分\n")
                        element = WebDriverWait(driver, 2).until(EC.presence_of_element_located((By.XPATH, "/html/body/div[2]/div/div/div[1]/div/div[2]")))
                        print("从这里找:\n\n\n"+element.text+"\n\n\n")
                        # scroll_by=element.location['y']
                        # driver.execute_script("window.scrollTo(0,arguments[0])", scroll_by)
                        html = element.get_attribute('outerHTML')
                        selector = Selector(text=html)
                        # print("看看处理以后的内容正不正确:\n\n\n"+selector.xpath('.').get()+"\n\n\n")
                        self.write_data(selector,i)
                        button.click()
                        print("再次点击该按钮关闭")
                    else:
                        print("获取按钮失败")
            except Exception as e:
                print("出问题辣: "+str(e))
                return



