package com.wordstalk.translate.common.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by y on 16/10/2.
 */
public class MainTest {

    public static void main(String[] args) {
        String s = "《人物传记》5本:新星出版社:新星出版社:杨英瑜%" +
                "《电力滤波器》:机械工业出版社-刘星宁:机械工业出版社:刘星宁%" +
                "《樱风堂物语》试译结束:广西师大（金晓燕）:广西师范大学:金晓燕%" +
                "各国条款:农业部-动物疫病预防控制中心:农业部动物疫病预防控制中心:李鹏%" +
                "《百日梦魇之前》:新星出版社-杨英瑜:新星出版社:杨英瑜%" +
                "《创业圣经》:广东经济出版社（Joyce）:广东经济出版社:陈念庄%" +
                "《我是创客》:广东经济出版社（Joyce）:广东经济出版社:陈念庄%" +
                "《花艺设计》两本:中国轻工业出版社-斯琴:中国轻工业出版社:斯琴%" +
                "《Entrepreneur's Playbook》/《企业家的剧本》:海南社-孙芳:海南出版社:孙芳%" +
                "《中国南海经贸文化志》《中国南海海洋文化史》:广东经济出版社（Joyce）:广东经济出版社:陈念庄%" +
                "《自我管理》/《关键改变》:华章出版社:北京华章图文信息有限公司:华蕾%" +
                "德润新邦-信息快报:重庆水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "2017-9-14“一带一路”战略背景下中国国际油气合作环境分析:石油工业出版社-高迎:石油工业出版社:高迎%" +
                "《比知识更重要的是想象力》:海南出版社:海南出版社:郄亚楠%" +
                "魏伟生育证明:魏伟:个人:魏伟%" +
                "《幸福的资本》论证:海南-孙芳:海南出版社:孙芳%" +
                "《人工智能》论证:海南-孙芳:海南出版社:孙芳%" +
                "《海上风力发电》:机工-刘星宁:机械工业出版社:刘星宁%" +
                "乐其-Batch 5:乐其-姜海婷:Leqee乐其:姜海婷%" +
                "毕业证:北京瑞纳德-刘阔:北京瑞纳德科技发展有限公司:刘阔%" +
                "赖总简历:重庆水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "《发现自己》外编:海南:海南出版社:郄亚楠%" +
                "《坐禅入门》外编:海南:海南出版社:郄亚楠%" +
                "账单发票等:CCCMHPIE-吴玉双:CCCMHPIE:吴玉双%" +
                "PRESIDENTIAL EXECUTIVE ORDER ON IMPOSING ADDITIONAL SANCTIONS WITH RESPECT TO NORTH KOREA:伟凯-BD-乔梁:美国伟凯律师事务所White&Case LLP:BD-乔良%" +
                "信息快报 [2017] 17号-重庆市环境保护技术大会暨重庆市环境科学学会第十一届学术年会:重庆水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "北科院&马来西亚城市大学&欧美亚战略合作框架协议（国外大学版本）V2:欧美亚教育联盟:德宏资本/三月资本:李忠军%" +
                "何沙--南方丝绸之路的政治经济分析：基于交通安全的视角:石油工业出版社-高迎:石油工业出版社:高迎%" +
                "北京瑞纳德合同审计报告等:北京瑞纳德-刘阔:北京瑞纳德科技发展有限公司:刘阔%" +
                "法信国际版ppt解说词:高院:最高人民法院:夏梦寒%" +
                "02 - Project Pistons - DD Report - 20.9.17:伟凯-王盛颖Caroline:美国伟凯律师事务所White&Case LLP:王盛颖Caroline/邓炯%" +
                "中国司法制度0507:高院:最高人民法院:夏梦寒%" +
                "《身边的366个为什么》:中青-沈莹:中国青年出版社:白峥%" +
                "乐其-Batch 4.2:乐其-姜海婷:Leqee乐其:姜海婷%" +
                "Company Profile - WordsTalk :沃资拓:沃资拓:沃资拓%" +
                "《跟吉卜力动画品味哲学》论证:海南社-孙芳:海南出版社:孙芳%" +
                "高管考核-翻译:重庆水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "Questionnaire_Government&FINAL 15.08.2017 EN - Cambios FS NEW_06092017_22h05 clean:人社部:人力资源与社会保障部:王涵/董晨阳/李处%" +
                "FINAL WC Proposal - Credit Suisse - Sept 2017:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "Project Pistons - Articles of Incorporation (W&C.09172017)&Project Pistons - Shareholders Agreement (W&C Draft.20170916):伟凯-王盛颖Caroline:美国伟凯律师事务所White&Case LLP:王盛颖Caroline/邓炯%" +
                "《金融的真相》论证:海南社:海南出版社:孙芳%" +
                "《植物在想什么》论证:海南社-周萌:海南出版社:周萌%" +
                "20170917下一步打算&20170917其余更改翻译&20170917管理建议书:重庆水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "董事会决议:重庆水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "《帝国是如何塑造我们的》论证:海南-孙芳:海南出版社:孙芳%" +
                "《人类本能》论证:海南-孙芳:海南出版社:孙芳%" +
                "国家食品药品监督管理总局关于调整进口药品注册管理有关事项的决定（征求意见稿）&中国加入ICH:CCCMHPIE-涂晓颖:CCCMHPIE:涂晓颖%" +
                "Project Pistons - Additional Report *5:伟凯-王盛颖Caroline:美国伟凯律师事务所White&Case LLP:王盛颖Caroline/邓炯%" +
                "听译-英语:宁德时代-Elaine:宁德时代新能源科技有限公司:黄祎霖Elaine%" +
                "Project Pistons - Additional Report - erae Korea (W&C Comments 09-12-201:伟凯-王盛颖Caroline:美国伟凯律师事务所White&Case LLP:王盛颖Caroline/邓炯%" +
                "M Reid CV:佳夏建筑设计GSA集团-王慧Laura:佳夏建筑设计GSA集团:王慧Laura%" +
                "听译-德语:宁德时代-Elaine:宁德时代新能源科技有限公司:黄祎霖Elaine%" +
                "20170912第一届董事会议案翻译:中法水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "Translation_GroupGSA Education :佳夏建筑设计GSA集团-王慧Laura:佳夏建筑设计GSA集团:王慧Laura%" +
                "0909 -德润新邦一届2次董事会会议材料（杨顺排板）:中法水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "谢-新的高管薪酬和绩效中更改:中法水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "Geneva - Waiver Consent Letter 20170908&Project Geneva - Intercreditorand Accounts Agreement 20170908:建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "《思维的囚徒》论证:海南出版社-孙芳:海南出版社:孙芳%" +
                "AWARDS LIST:佳夏建筑设计GSA集团-王慧Laura:海南出版社:孙芳%" +
                "低油价下国际石油公司向低碳能源转型的进展与启示:石油工业出版社:石油工业出版社:高迎%" +
                "extended essay:兆维集团:北京兆维电子(集团)有限责任公司:刘东凯/卫媛%" +
                "Comsumer - Retail Industry Select Experience - Aug 2017:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "《蜘蛛网》《黑咖啡》《意外的客人》:新星出版社:新星出版社:杨英瑜%" +
                "修改-佛山南海技术标书（英文版）20170628:卡塔克-于丹:北京卡达克科技中心:于丹%" +
                "乐其-Batch 4.1:乐其-姜海婷:Leqee乐其:姜海婷%" +
                "《电网通讯》-智能电网的安全和隐私-Security and Privacy in Smart Grids:机械工业出版社（刘星宁）:机械工业出版社:刘星宁%" +
                "《二次获利》:清华大学出版社:清华大学出版社:刘样%" +
                "更新—集团宣传册文字内容20170901:兆维集团:北京兆维电子(集团)有限责任公司:刘东凯/卫媛%" +
                "《墨香世家》外编:海南:海南出版社:郄亚楠%" +
                "《水彩的魅力》:人邮-易舟:人民邮电出版社:易舟%" +
                "电子出版承诺书:海南出版社:海南出版社:郄亚楠%" +
                "《美国少儿探索》:北京和合天下文化发展有限公司:北京和合天下文化发展有限公司:张腾龙/吴建玲%" +
                "公司名称中译英明细:北京思源互联科技有限公司:北京思源互联科技有限公司:王珊珊%" +
                "《女子防身术》:人邮-王雅倩:人民邮电出版社:王雅倩%" +
                "UNIDO-中国新能源汽车示范推广政策效果评价报告大纲-20170829:中国汽车工程学会（陈敏）:中国汽车工程学会:陈敏%" +
                "《电网通讯》-智能电网中的通信与网络-Communication and Networking in Smart Grids:机械工业出版社（刘星宁）:机械工业出版社:刘星宁%" +
                "《手印脚印画》:人民邮电出版社-王铁:人民邮电出版社:王铁%" +
                "沃资拓兼职协议:沃资拓:沃资拓:沃资拓%" +
                "170818pji_德润新邦_常年顾问_《章程--德润环境修复公司（增加党组织内容）》&170818pji_德润新邦_常年顾问_《德润新邦章程修正案》&2017年1-6月工作总结:中法水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "Money transfer records:中法水务-德润-胡雨:德润:胡雨%" +
                "XX补充问题回复8.24:探路者控股集团股份有限公司:探路者控股集团股份有限公司:于雨Vicky%" +
                "《厦门购物指南翻译》:厦门华亿传媒集团股份有限公司-李林:厦门华亿传媒集团股份有限公司:何%" +
                "Flyer Translation:Brendon:Immigration Capital:Brendon.Biegel%" +
                "Caixin - Share Purchase Agreement:中金甲子-姜菲:中金甲子（北京）投资基金管理有限公司:姜菲%" +
                "810 -德润新邦一届二次董事会会议材料:中法水务-德润新邦-龙敏:德润新邦:龙敏%" +
                "翻译内容:中国汽车工程学会:中国汽车工程学会:陈敏%" +
                "乐其-0811~0817-12个文件:乐其-姜海婷:Leqee乐其:姜海婷%" +
                "《成吉思汗密码》外编:海南出版社:海南出版社:郄亚楠%" +
                "“南京的创伤”项目:JZ:北京壹眼视界文化传媒有限公司:贾竹JZ%" +
                "《茶界中国》彩页资料:中国轻工业出版社:中国轻工业出版社:巴丽华%" +
                "《林亮太组合》:人邮:人民邮电出版社:王雅倩%" +
                "Bio -Farhad and Daniel - ENG:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "《厨神坊经典料理》:海南出版社-周萌:海南出版社:周萌%" +
                "《CG场景动画制作》:人邮:人民邮电出版社:王雅倩%" +
                "《金砖折页》/《厦门会晤系列折页》:厦门华亿传媒集团股份有限公司-李林:厦门华亿传媒集团股份有限公司:何%" +
                "Project Pistons - Additional Report - erae Korea - For Translation:伟凯-王盛颖Caroline:美国伟凯律师事务所White&Case LLP:王盛颖Caroline/邓炯%" +
                "《潘家园古佣迷案》外编:海南出版社:海南出版社:郄亚楠%" +
                "《走向海洋》/《丝路帆影》:厦门华亿传媒集团股份有限公司-李林:厦门华亿传媒集团股份有限公司:何%" +
                "燃料电池汽车发展路线图结题报告0717:北京卡达克-于丹:北京卡达克科技中心:于丹%" +
                "MSF Access Campaign 2016 Year in Review:无国界医生:无国界医生:王玮%" +
                "《诗画厦门》:厦门华亿传媒集团股份有限公司-李林:厦门华亿传媒集团股份有限公司:何%" +
                "《姐妹会》:化工社:化学工业出版社:邵轶然%" +
                "关于对亚洲开发银行贷款湖南职业教育 示范项目审计报告的整改情况报告:湖南省教育厅:湖南省教育厅:魏欣%" +
                "Chapter 11 Presentation&2017-06-28 Eagle - All Lender Materials - Chapter 11 Extract for Translation:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "乐其-0731~0804-6个文件:乐其-姜海婷:Leqee乐其:姜海婷%" +
                "《厦门雅游经典线路手册》:厦门华亿传媒集团股份有限公司-李林:厦门华亿传媒集团股份有限公司:何%" +
                "中汽学会8.1需要翻译的文档:中国汽车工程学会:中国汽车工程学会:陈敏%" +
                "《ANA-Can_finance_save_the_world》论证:海南出版社:海南出版社:郄亚楠%" +
                "Introducing White  Case Experience - July 2017:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "云南 滇池 亿利资源重大生态产业投资项目 策划及概念规划设计咨询委托合同:佳夏建筑设计GSA集团-王慧Laura:佳夏建筑设计GSA集团:王慧Laura%" +
                "《厨神坊甜点》:海南出版社-周萌:海南出版社:周萌%" +
                "《理科事典》:中青-沈莹:中国青年出版社:白峥%" +
                "《小S终极导师》外编:海南出版社:海南出版社:郄亚楠%" +
                "XX问题回复7.27:探路者控股集团股份有限公司:探路者控股集团股份有限公司:于雨Vicky%" +
                "Project Geneva - Intercreditor and Accounts Agreement:建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "FDA医药注册文件:迅达药业-吴秀兰:湖北迅达药业股份有限公司:吴秀兰%" +
                "17期班关于毕业证的诉求:清华ANU校友会:清华ANU校友会:孙立琴%" +
                "测井公司“一带一路”征文：脚步，在“一带一路”上行走（罗义）:石油工业出版社:石油工业出版社:高迎%" +
                "护照&银行流水翻译:Khurram Anzar:个人:Khurram Anzar%" +
                "W&C Credentials in Asset based financing - July 2017:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "IFC - Union Life - Shareholders Undertaking Agreement:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "Bio_Lau_Timothy - Pitch - 4 January 2017:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "《临济录随想》外编:海南出版社:海南出版社:郄亚楠%" +
                "《大唐狄公案》外编:海南出版社:海南出版社:郄亚楠%" +
                "《无门关漫步》外编:海南出版社:海南出版社:郄亚楠%" +
                "IFC_Union Life - Policy Agreement 20170717（新增&修改）:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "《厦门地图》:厦门华亿传媒集团股份有限公司-李林:厦门华亿传媒集团股份有限公司:何%" +
                "乐其-0717~0720-6个文件:乐其-姜海婷:Leqee乐其:姜海婷%" +
                "《印象厦门》:厦门华亿传媒集团股份有限公司-李林:厦门华亿传媒集团股份有限公司:何%" +
                "BRICS Labour Market Trends:人社部:人力资源与社会保障部:王涵/董晨阳/李处%" +
                "《交易室中的野蛮人》:华章-顾煦:北京华章图文信息有限公司:顾煦%" +
                "江格尔动漫简介:大海:江格尔项目组:大海%" +
                "AP201702-014_Australia EIPF Brochure_ENG_11:伟凯-BD-乔良:美国伟凯律师事务所White&Case LLP:BD-乔良%" +
                "TDP location release Fee&TDP personal release&TDP personal release:JZ:北京壹眼视界文化传媒有限公司:贾竹JZ%" +
                "IFC_XN Noodle - Sponsor Undertaking Agreement 20170713:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "CS Bermuda opinion - draft v4&CS BVI Opinion - draft v2:建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "《癌症能奈我何》论证:海南出版社:海南出版社:郄亚楠%" +
                "Project Eagle:伟凯-许梦笔-刘天韧:美国伟凯律师事务所White&Case LLP:许梦笔&刘天韧%" +
                "Engagement Letter - Qingdao Port 9 July 2017:伟凯-BD:美国伟凯律师事务所White&Case LLP:BD-乔良%" +
                "《从漫画入门让你成为足球少年》:中青-沈莹:中国青年出版社:白峥%" +
                "《从漫画入门篮球》:中青-沈莹:中国青年出版社:白峥%" +
                "安洁奥-MikroIC说明书:安洁奥医疗器械（北京）有限公司:安洁奥医疗器械（北京）有限公司:吕瑶Laura%" +
                "HK-#22408038-v7A-Project_Diamond_-_Equity_Collar_(Excl__CSA):伟凯-June:美国伟凯律师事务所White&Case LLP:June%" +
                "IFC XN Noodle Rights Agreement新增&修改:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "《从漫画入门简单魔术》:中青-沈莹:中国青年出版社:白峥%" +
                "HK-#22399138-v13A-Diamond_-_Bilateral_Facility_Agreement_for_Margin_Loan... (1):伟凯-June:美国伟凯律师事务所White&Case LLP:June%" +
                "《力量自由与荣耀》论证:海南出版社:海南出版社:郄亚楠%" +
                "《海格力斯——催眠的艺术》论证:海南出版社:海南出版社:郄亚楠%" +
                "《从漫画入门游泳》:中青-沈莹:中国青年出版社:白峥%" +
                "《电力变换站》:机械工业出版社-顾谦:机械工业出版社:顾谦%" +
                "《艾扬格传》外编:海南出版社:海南出版社:郄亚楠%" +
                "《从人生低谷走向巅峰》论证:海南出版社:海南出版社:郄亚楠%" +
                "论文3.0:Rachel:个人:Rachel%" +
                "《太空探索》论证:海南社-孙芳:海南出版社:孙芳%" +
                "《欢迎来到元素都市》:中青-沈莹:中国青年出版社:白峥%" +
                "西语-Aliexpress:Gllinking-Alex:Gllinking:Candy Liu%" +
                "骨髓移植中心设备清单:CCCMHPIE-援外-任芳:中国医药保健品进出口商会CCCMHPIE:任芳%" +
                "《销魂甜点》:海南出版社-周萌:海南出版社:周萌%" +
                "Sokhna Port - Heads of Terms - Basin 2 Concessio:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "IFC_Union Life - Policy Agreement 20170623:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "IFC - Union Life Put Option and Rights Agreement 20170621:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "《电力电子学及电机驱动》:机械工业出版社-何世娟:机械工业出版社:何世娟%" +
                "《人体迷宫调查之食物的去向》:中青-沈莹:中国青年出版社:白峥%" +
                "中铝铁矿bfs优化汇报20170619 7:刘志良:个人:刘志良%" +
                "《大数据》论证:海南出版社:海南出版社:郄亚楠%" +
                "7月7日上午:cccmhpie-任芳:中国医药保健品进出口商会CCCMHPIE:任芳%" +
                "《美少女蝶拟人图鉴》:中青-沈莹:中国青年出版社:白峥%" +
                "亚洲开发银行贷款湖南职业教育示范项目2016年度财务收支及执行情况审计报告(翻译稿):湖南省教育厅:湖南省教育厅:魏欣%" +
                "1.合众人寿保险股份有限公司公司章程（变更后）:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "《汽车底盘I卷&II卷》:机械工业出版社:机械工业出版社:何士娟%" +
                "《疾病的哲学》外编:海南出版社:海南出版社:郄亚楠%" +
                "“一带一路”这三年：中国企业的新打法和新问题:石油工业出版社:石油工业出版社:高迎%" +
                "《50种发现里的医药史》论证:海南出版社:海南出版社:郄亚楠%" +
                "Kidde-中文配音稿-0602-翻译:海湾安全技术有限公司-赵大林:海湾安全技术有限公司:赵大林%" +
                "2017年电动汽车示范城市 会议总结:中国汽车工程学会:中国汽车工程学会:陈敏%" +
                "IFC_Kingenta - Loan Agreement -2:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "《少儿瑜伽》外编:海南出版社:海南出版社:郄亚楠%" +
                "伊可资料翻译:伊可:个人:伊可%" +
                "中俄圆桌会议合拍项目信息:JZ:北京壹眼视界文化传媒有限公司:贾竹JZ%" +
                "翻译170609:cccmhpie-任芳:中国医药保健品进出口商会CCCMHPIE:任芳%" +
                "新版待译文件 采矿部分介绍2017.6.7:刘志良:个人:刘志良%" +
                "HSBC US Asia Financing:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "SINGAPORE - AP201508-007_Singapore Office Brochure&Singapore Public M&A experience:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "IFC_Kingenta - Guarantee (revised):伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "International Experience on the Reform of Provider payment mechanisms of Health Insurance:ILO:ILO:Wu Ninan%" +
                "IFC - Union Life Subscription Agreement (W&C Draft 20170606):伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "《Cracking the China Conundrum》论证:海南社-孙芳:海南出版社:孙芳%" +
                "Bermudan Share Mortgage - TF Holdings Limited v3 20170606:建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "Licence to Film:University of Huddersfield-大齐:University of Huddersfield:大齐%" +
                "《管理类》试译:海南社-諶紫灵:海南出版社:諶紫灵%" +
                "《From Byzantium to Italy》论证:海南社-孙芳:海南出版社:孙芳%" +
                "IFC_XN Noodle - Subscription Agreement [CH] 20170604:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "银行流水翻译:德润胡雨:德润:胡雨%" +
                "IFC_XN Noodle - Policy Agreement 20170601:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "巴西项目9亿美元银团贷款合同-签字版&刚果项目15.9亿美元银团贷款合同-签字版:洛阳钼业:洛阳栾川钼业集团股份有限公司:金鑫%" +
                "问答翻译:伊可:个人:伊可%" +
                "附件一 政府能力建设工作&附件二 政府审批流程 事项及审批部门&附件三 项目协调办和一站服务办的组建:刘志良:个人:刘志良%" +
                "白话文试译:高院:最高人民法院:夏梦寒%" +
                "关于路线图的说明（GOG）:刘志良:个人:刘志良%" +
                "《人体迷宫调查之在血液循环中冒险》:中青-沈莹:中国青年出版社:白峥%" +
                "《Crews, F. FREUD THE MAKING OF AN ILLUSION. Second Pass》论证:海南社-孙芳:海南出版社:孙芳%" +
                "Union Life Subscription Agreement (W&C Draft 20170526) (for translation):伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "采矿部分介绍:刘志良:个人:刘志良%" +
                "Helsinki Office Brochure  June 2016:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "PANJIANG GROUP（PPT）:杨凯越:个人:杨凯越%" +
                "Bermudan Share Mortgage - LundinDRC Holdings Ltd v8 (agreed form):伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "Bermudan Share Mortgage - TFHoldings Limited:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "如何为城市公共交通选择一款好电池（PPT）:宁德时代-李茂正:宁德时代新能源科技有限公司:李茂正%" +
                "《Happiness Explained》论证:海南社-孙芳:海南出版社:孙芳%" +
                "IFC_XN Noodle - Rights Agreement 20170521:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "《从漫画入门求生术》:中青-沈莹:中国青年出版社:白峥%" +
                "教材讲义:旭洋群美-南瓜姑娘:北京旭洋群美科技有限公司-南瓜姑娘:李洋%" +
                "《从漫画入门未来的职业》:中青-沈莹:中国青年出版社:白峥%" +
                "IFC_Hainan RCU - Loan Agreement 20170522:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "镜中猎杀-法语字幕:妖艳左轮-李宗衡:北京妖艳左轮国际文化传媒有限公司:李宗衡%" +
                "官网翻译-中德:宁德时代-Elaine:宁德时代新能源科技有限公司:黄祎霖Elaine%" +
                "Rider (Article 79 CISG) - Practical Guide for CNOOC:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "官网翻译-中英:宁德时代-Elaine:宁德时代新能源科技有限公司:黄祎霖Elaine%" +
                "上海索菲垭国际贸易有限公司章程&营业执照:上海索菲垭国际贸易有限公司:上海索菲垭国际贸易有限公司:葛莹莹%" +
                "Quinta do Crasto - Portugal:EB5:EB5 益博:朱文慧Catherine/Aleksandra%" +
                "海湾公司简介&垂直产品线手册:海湾安全技术有限公司-赵大林:海湾安全技术有限公司:赵大林%" +
                "《肯德基创始人和美国梦》:时代书局（张彦祥）:北京时代华文书局有限公司:张彦祥%" +
                "CNOOC Guide-Frustration under English law:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "《瑜伽经的核心》外编:海南出版社:海南出版社:郄亚楠%" +
                "Test Translation - NSFE-ILO:ILO试译:ILO:Xu Yichun&Zhang Renling%" +
                "IFC_XN Noodle - Subscription Agreement:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "《沉默的另一端》外编:海南出版社:海南出版社:郄亚楠%" +
                "1-Board Resolutions_April 28:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "详细人物介绍:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "《从幼儿到小学的基本概念》论证:中青出版社:中国青年出版社:白峥%" +
                "中华法系文献及简介:高院:最高人民法院:夏梦寒%" +
                "伟凯BD-0515:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "终止合同的会议纪要:湖南省教育厅:湖南省教育厅:魏欣%" +
                "《从零开始：吉他超级入门》两本:人民邮电出版社-杜梦萦:人民邮电出版社:杜梦萦%" +
                "《5G通讯的前传和回传》:机械工业出版社-吕潇:机械工业出版社:吕潇%" +
                "集团适合出口产品清单:兆维集团-刘东凯:北京兆维电子(集团)有限责任公司:刘东凯/卫媛%" +
                "《柏林1936》:海南出版社:海南出版社:郄亚楠%" +
                "企鹅试译:200本书评:企鹅图书（中国）:李梦琦%" +
                "救助儿童会试译:救助儿童会:救助儿童会:刘育婷%" +
                "4个产品宣传册:安洁奥医疗器械（北京）有限公司:安洁奥医疗器械（北京）有限公司:吕瑶Laura%" +
                "《机械昆虫的制作》:中青社-白峥:中国青年出版社:白峥%" +
                "Warsw office_M&A credentials_05.2017:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "明胶空心胶囊合同书:浙江华光胶囊-潘缓孝:浙江华光胶囊股份有限公司:潘缓孝%" +
                "《冥想的奥秘》论证:海南出版社-周萌:海南出版社:周萌%" +
                "判决书*2:伟凯上海-颖骅:美国伟凯律师事务所White&Case LLP:颖骅%" +
                "《超级厉害的立即执行力》:时代书局-张彦祥:北京时代华文书局有限公司:张彦祥%" +
                "《向阿德勒学习》:海南出版社:海南出版社:郄亚楠%" +
                "【Limibot】文案:厘米脚印:厘米脚印:孙桥%" +
                "情势变更备忘录-中伦April 26:伟凯-BD:美国伟凯律师事务所White&Case LLP:BD-乔良%" +
                "Facilitator's Guide FINAL PES_WEB:ILO-贾佳:ILO:贾佳%" +
                "For translation-有关未来:UNICEF:UNICEF:张文%" +
                "CCB_China Moly - Draft target share charge:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "网站本地化:安洁奥医疗器械（北京）有限公司:安洁奥医疗器械（北京）有限公司:吕瑶Laura%" +
                "G20劳工就业部长会议部长宣言:人社部:人力资源与社会保障部:王涵/董晨阳/李处%" +
                "《寻找村上春树的东京》外编:海南出版社:海南出版社:郄亚楠%" +
                "G20自我报告:人社部:人力资源与社会保障部:王涵/董晨阳/李处%" +
                "BRICS Labour Market Trends:ILO-贾佳:ILO:贾佳%" +
                "《艾扬格调息之光》外编:海南出版社:海南出版社:郄亚楠%" +
                "测试稿:ILO-WANG Haifang:ILO:王海芳%" +
                "PPT，Kapsos - MOHRSS*2:ILO-贾佳:ILO:贾佳%" +
                "Italian Practice Brochure:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "Italian Corporate and MA practice - Public M&A:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "石油新闻稿*7:石油工业出版社:石油工业出版社:高迎%" +
                "试译-节能与新能源汽车技术路线图正文:中国汽车工程学会:中国汽车工程学会:陈敏%" +
                "《从心觉醒》外编:海南出版社:海南出版社:郄亚楠%" +
                "International Brochure:University of Hudersfield-大齐:University of Huddersfield:大齐%" +
                "格林威治时间-故事梗概:University of Hudersfield-大齐:University of Huddersfield:大齐%" +
                "《危机重重》:化工社:化学工业出版社:邵轶然%" +
                "益博项目文件翻译-Hyatt补充-Escrow Agreement::EB5:EB5 益博:朱文慧Catherine/Aleksandra%" +
                "益博项目文件翻译-Mark-01&05&06:EB5:EB5 益博:朱文慧Catherine/Aleksandra%" +
                "CCB_China Moly - Comprehensive Service Fee:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "《做幸福的妈妈》外编:海南出版社:海南出版社:郄亚楠%" +
                "法律意见书*4:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "Mining & Metals Global Brochure:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "案例试译:高院:最高人民法院:夏梦寒%" +
                "胡杨的夏天:新疆富布斯影视文化传媒有限公司:新疆富布斯影视文化传媒有限公司:马岩%" +
                "CCB_China Moly - CP Confirmation:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "自我介绍:工人出版社刘宇:中国工人出版社:刘宇%" +
                "Project Light - Share Pledge - 22 March 2017&Project Light - Amendment Agreement - 6 March 2017:伟凯-June:美国伟凯律师事务所White&Case LLP:June%" +
                "《成长企业的法则》:海南出版社-谌紫玲:海南出版社:孙芳%" +
                "CCB_China Moly - Borrower Account Charge 20170322-更新:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "Project Geneva - Escrow Agreement (Equity) 修改:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "Geneva - Fee Letters费用函更新版*5:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "FA修改:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "CCB_China Moly - Facility Agreement-CH-readline-0321:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "Press release - 17 March - For translation:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "upfront fee& agency fee& security agency fee&Shanghai Electric Power & Energy Loan Facility 20170317:伟凯-June:美国伟凯律师事务所White&Case LLP:June%" +
                "乐其-02-40659&36831:乐其:Leqee乐其:姜海婷%" +
                "《书法教科书》:人民邮电出版社-王铁:人民邮电出版社:王铁%" +
                "益博项目文件翻译-Artistry:EB5:EB5 益博:朱文慧Catherine/Aleksandra%" +
                "41474994_6 Project Geneva - Escrow Agreement-Equity::伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "China MA report client letter - for translation:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "ILO-170309-8个文件-贾佳:ILO-贾佳:ILO:贾佳%" +
                "Share Pledge Release& Target Share Pledge Agreement:伟凯-June:美国伟凯律师事务所White&Case LLP:June%" +
                "CCB-China Moly - Legal Opinions*4:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "CCB_China Moly - Account Bank Fee Letter 20170313:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "《炒股》外编:华章-顾煦:北京华章图文信息有限公司:顾煦%" +
                "Project Geneva - Facilities Agreement新增&修改:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "《伤寒杂病诠解》外编:海南出版社:海南出版社:郄亚楠%" +
                "益博项目文件翻译-Mark-第二批:EB5:EB5 益博:朱文慧Catherine/Aleksandra%" +
                "《阿育吠陀疗愈之轮》外编:海南出版社:海南出版社:郄亚楠%" +
                "Yan vs Zhang - Yan Wei Min Witness Outline:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "费用函*4:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "乐其-第十六批-2个文件:乐其:Leqee乐其:姜海婷%" +
                "卡尔森EHR管理系统合同-昆山同鑫20170301:东阳光:东阳光:王旭明/郑清%" +
                "FINAL Credit Suisse 2017 Legal Panel Renewal:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "08884_ENV_Climate_Generic_v9:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "BCMR - Securitization:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "乐其-第十五批-1个文件:乐其:Leqee乐其:姜海婷%" +
                "3个报告:ILO:ILO:Wu Ninan%" +
                "CCB_China Moly - Borrower Account Charge 20170224:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "CCB_China Moly - Security Assignment 20170224:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "补充翻译-170227:伊可:个人:伊可%" +
                "伊可ppt:伊可:个人:伊可%" +
                "瑞士申请翻译:伊可:个人:伊可%" +
                "神算-筹备版:故事会:故事会:史一鸣%" +
                "PPM - East Purple Macro Strategy Fund - part-试译:试译:个人:黎琦%" +
                "制裁政策咨询相关需求:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "20170220TS中文翻译CCB_China Moly - Term Sheet (Ch):伟凯-建行杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "UNFPA-试译:UNFPA:UNFPA:王岩%" +
                "产品简介-改写:Mark:个人:Mark%" +
                "乐其-第十四批-4个文件:乐其:Leqee乐其:姜海婷%" +
                "Project Light - Translation (custodian account agreement):伟凯-June:美国伟凯律师事务所White&Case LLP:June%" +
                "Project Light - Security Assignment:伟凯-June:美国伟凯律师事务所White&Case LLP:June%" +
                "十二届世界芒果大会日程（一句话）:广东陈水群:个人:陈水群%" +
                "《人工智能》简介:时代书局-张彦祥:北京时代华文书局有限公司:张彦祥%" +
                "CCB_China Moly - Facility Agreement 20170214:伟凯-建行-杜菲:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "安乐-剧本EP9EP10EP11:故事会:故事会:史一鸣%" +
                "乐其-第十三批-8个文件:乐其:Leqee乐其:姜海婷%" +
                "LON0217056 FACTSHEET RE for Chinese Investors:伟凯-姜颖-BD:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "《The Great Devide》外编:华章-顾煦:北京华章图文信息有限公司:顾煦%" +
                "《自卑与超越》:北京安帛图文设计中心:北京安帛图文设计中心:安子%" +
                "洛钼项目国际商业转贷款协议——约堡分行:伟凯-建行:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "洛钼项目国际商业转贷款协议——首尔分行:伟凯-建行:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "Trade Practice Group Capability Statement&&US IPO credentials - for translation:伟凯-BD:美国伟凯律师事务所White&Case LLP:BD-乔良%" +
                "乐其-第十二批-2个文件:乐其:Leqee乐其:姜海婷%" +
                "《灰度管理》:华章:北京华章图文信息有限公司:华蕾%" +
                "灵猫-剧本EP15EP16EP17:故事会:故事会:史一鸣%" +
                "益博项目文件翻译-Hyatt:EB5:EB5 益博:朱文慧Catherine/Aleksandra%" +
                "使用说明书翻译-4个文件:安洁奥医疗器械（北京）有限公司:安洁奥医疗器械（北京）有限公司:吕瑶Laura%" +
                "Project Light - Subordination Deed:伟凯-June:美国伟凯律师事务所White&Case LLP:June%" +
                "Project Light - Accounts Charge (draft):伟凯-June:美国伟凯律师事务所White&Case LLP:June%" +
                "乐其-第十一批-5个文件:乐其:Leqee乐其:姜海婷%" +
                "乐其-第九批-11个文件:乐其:Leqee乐其:姜海婷%" +
                "乐其-第十批-3个文件:乐其:Leqee乐其:姜海婷%" +
                "《创造圣经的城市》外编:海南出版社:海南出版社:郄亚楠%" +
                "Ceramill Units_Broschüre_AG5603_160923_EN_v18_300:安洁奥医疗器械（北京）有限公司:安洁奥医疗器械（北京）有限公司:吕瑶Laura%" +
                "WO2015071779A1&WO2016001868A1:北京轻创知识产权代理:北京轻创知识产权代理:文敬琴%" +
                "20170208中文版CCB_China Moly - Term Sheet:伟凯-建行（杜菲）:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "煤改气政策解读:石油工业出版社:石油工业出版社:高迎%" +
                "Draft Agenda-Global Conf on Ed Jakarta 2 Feb 2017 - Sent to Participants&CHINA -- Xu Wei:湖南省教育厅:湖南省教育厅:魏欣%" +
                "《漫画入门》十本试译:中青出版社:中国青年出版社:白峥%" +
                "乐其-第八批-5个文件:乐其:Leqee乐其:姜海婷%" +
                "乐其-第七批-2个文件:乐其:Leqee乐其:姜海婷%" +
                "乐其-第六批-4个文件:乐其:Leqee乐其:姜海婷%" +
                "《南海志-试译》:广东经济出版社（Joyce）:广东经济出版社:陈念庄%" +
                "乐其-第五批-2个文件:乐其:Leqee乐其:姜海婷%" +
                "Project Light - Keepwell Deed:伟凯-Kevin-June:美国伟凯律师事务所White&Case LLP:Kevin&June%" +
                "Project Light - Facility Agreement:伟凯-Kevin-June:美国伟凯律师事务所White&Case LLP:Kevin&June%" +
                "Proposal to SRF - Jan 2017-前十页:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "在职证明:石油工业出版社:石油工业出版社:高迎%" +
                "乐其-第四批-8个文件:乐其:Leqee乐其:姜海婷%" +
                "SRF - fee section (3):伟凯-BD姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "法律顾问服务协议:伟凯-BD-姜颖:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "IFC_Yangxiang - Loan Agreement:伟凯-许梦笔:美国伟凯律师事务所White&Case LLP:许梦笔%" +
                "乐其-第三批-1个文件:乐其:Leqee乐其:姜海婷%" +
                "乐其-第二批-2个文件:乐其:Leqee乐其:姜海婷%" +
                "乐其-第一批-7个文件:乐其:Leqee乐其:姜海婷%" +
                "CCB_China Moly - Mandate Letter:伟凯-建行（杜菲）:中国建设银行股份有限公司洛阳分行:杜菲%" +
                "《强大领袖的神话》论证:海南出版社:海南出版社:郄亚楠%" +
                "《内容机器》外编:华章:北京华章图文信息有限公司:华蕾%" +
                "《数码时代》外编:华章:北京华章图文信息有限公司:华蕾%" +
                "VERSUM MATERIALS试译段落1230:中国船舶重工集团:中国船舶重工集团:郑艺%" +
                "《汽车车身I卷》（审校 翻译）:机械工业出版社:机械工业出版社:何士娟%" +
                "网站翻译ORG UNI:TAG:TAG 塔拉勒·阿布格扎拉集团:韩达%" +
                "《数码时代》:华章:北京华章图文信息有限公司:华蕾%" +
                "《内容机器》:华章:北京华章图文信息有限公司:华蕾%" +
                "《小学生的第一本科学》-五本-论证:中青社:中国青年出版社:白峥%" +
                "GE-Haier Jiaonan Product Sourcing Contract Exp 123117:伟凯WhiteCase-张熙:美国伟凯律师事务所White&Case LLP:张熙%" +
                "Ethiopia-Transitioning&Ethiopia Final budget_Dec 9:UNDP:UNDP:Ya Lou&Benjamin Moore&Zhang Yan&肖怡Sara&Shao Miaomiao%" +
                "《基金经理的创业之路》外编:华章:北京华章图文信息有限公司:华蕾%" +
                "《证券分析师眼中的黄金时代》外编:华章:北京华章图文信息有限公司:华蕾%" +
                "Sri Lanka Transitionning&Sri Lanka Final budget_Dec9:UNDP:UNDP:Ya Lou&Benjamin Moore&Zhang Yan&肖怡Sara&Shao Miaomiao%" +
                "Azerbaijan cambodia project references. 12.12:UNDP:UNDP:Ya Lou&Benjamin Moore&Zhang Yan&肖怡Sara&Shao Miaomiao%" +
                "Overview of proposals submissions to MOFCOM DFA& Similar project experience and successes:UNDP:UNDP:Ya Lou&Benjamin Moore&Zhang Yan&肖怡Sara&Shao Miaomiao%" +
                "Comments on the Fiji proposal &Comments on the Kenya Proposal&additional translation for fiji proposal:UNDP:UNDP:Ya Lou&Benjamin Moore&Zhang Yan&肖怡Sara&Shao Miaomiao%" +
                "《最后的数学战士》四本-论证:中青社:中国青年出版社:白峥%" +
                "Monzambique&Maldives - Projects experiences:UNDP:UNDP:Ya Lou&Benjamin Moore&Zhang Yan&肖怡Sara&Shao Miaomiao%" +
                "发票翻译:兆维集团:北京兆维电子(集团)有限责任公司:刘东凯/卫媛%" +
                "91217352_1&AAG-RGM:伟凯WhiteCase-BD:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "GER0615011_Energy_Germany_E_17_September 2016:伟凯WhiteCase-BD:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "Global Power Borchure:伟凯WhiteCase-BD:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "翻译文档1207:中国汽车工程学会:中国汽车工程学会:陈敏%" +
                "《三本法语论证》:中青社:中国青年出版社:白峥%" +
                "national-security-reviews:伟凯WhiteCase-BD:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "《成都》润色试译-失败:地图社:中国地图出版社:朱萌%" +
                "《恐龙的绘画方法》:人民邮电出版社-王铁:人民邮电出版社:王铁%" +
                "2016年节能与新能源汽车产业发展高峰论坛总结:中国汽车工程学会:中国汽车工程学会:陈敏%" +
                "Translation-Key Challenges Facing Children 2016:UNICEF:UNICEF:张文%" +
                "《人工智能》外编:机械工业出版社:机械工业出版社:何士娟%" +
                "05511_Global_Power_M-1125:伟凯WhiteCase-BD:美国伟凯律师事务所White&Case LLP:BD-姜颖%" +
                "日本驻留计划申请表:伊可:个人:伊可%" +
                "《超级食物》论证翻译:海南出版社:海南出版社:郄亚楠%" +
                "宜昌药业重组人胰岛素生物等效性试验总结报告:东阳光:东阳光:王旭明/郑清%" +
                "中央电视台与西班牙维亚国际公司第三期酒店落地合作协议 CN（161122中午）:北京市康祥国际旅游有限公司:北京市康祥国际旅游有限公司:李倩%" +
                "两个人:伊可:个人:伊可%" +
                "《自然疗法》论证翻译:海南出版社:海南出版社:郄亚楠%" +
                "Norrag SDG4 China UNICEF:UNICEF:UNICEF:张文%" +
                "石油央企改革要突破资产结构优化的政策关口:石油工业出版社:石油工业出版社:高迎%" +
                "《孤独星球-古巴》:Lonely Planet 王玫珺:Lonely Planet:王玫珺%" +
                "《电视剧的作法》外编:海南出版社:海南出版社:郄亚楠%" +
                "手表术语:手表:个人:Kwylauwy%" +
                "上海之鱼:佳夏建筑设计-GSA集团:佳夏建筑设计-GSA集团:Laura王慧%" +
                "Tiguan邀请函_1106v2:大众:个人:娜娜%" +
                "关于提高亚行贷款项目财务专员补助的请示:湖南省教育厅:湖南省教育厅:魏欣%" +
                "中国残障人平等获得司法保护研究报告:UNDP:UNDP:Ya Lou&Benjamin Moore&Zhang Yan&肖怡Sara&Shao Miaomiao%" +
                "无锡职业技术学院培训合同&名单:湖南省教育厅:湖南省教育厅:魏欣%" +
                "七十周年PPT更新版:UNICEF:UNICEF:张文%" +
                "16_10_26 Child Poverty Op-ed draft:UNICEF:UNICEF:张文%" +
                "PPT节能与新能源汽车技术路线图 编制情况汇报:中国汽车工程学会:中国汽车工程学会:陈敏%" +
                "介绍:大海:江格尔项目组:大海%" +
                "查证申请函&关于部分电信设备进网许可证核实情况的复函:湖南省教育厅:湖南省教育厅:魏欣%" +
                "《手提袋设计》:人民邮电出版社:人民邮电出版社:王铁%" +
                "Iodine Press Release:UNICEF:UNICEF:张文%" +
                "中央电视台与维亚第三期酒店落地推广合作协议:北京市康祥国际旅游有限公司:北京市康祥国际旅游有限公司:李倩%" +
                "江格尔1-7集西语字幕:大海:江格尔项目组:大海%" +
                "蒙语:李春兵:个人:李春兵%" +
                "摄影补充:UNICEF:UNICEF:张文%" +
                "路线图分包:中国汽车工程学会（葛莹莹）:中国汽车工程学会:葛莹莹%" +
                "展示项目 CV:湖南省教育厅:湖南省教育厅:魏欣%" +
                "EV-RE 附录B/F/I:中国汽车工程学会（亚莉/斯琪）:中国汽车工程学会:郑亚莉&赵斯琪%" +
                "七十周年PPT:UNICEF:UNICEF:张文%" +
                "试译:伟凯WhiteCase:美国伟凯律师事务所White&Case LLP:BD-乔良%" +
                "试译:国家电网管理学院:国家电网管理学院:孟雯%" +
                "《人工智能》:机械工业出版社:机械工业出版社:何士娟%" +
                "担保信贷能力PPT:亨德森:亨德森:Sunny&Charles%" +
                "Child Photography Exhibition Concept Note:UNICEF:UNICEF:张文%" +
                "《汽车车身II卷》审校:机械工业出版社:机械工业出版社:何士娟%" +
                "《电视剧的作法》:海南出版社:海南出版社:郄亚楠%" +
                "EV-RE翻译文稿项目论证:中国汽车工程学会（亚莉/斯琪）:中国汽车工程学会:郑亚莉&赵斯琪%" +
                "银证记录:中法水务-德润:德润:胡雨%" +
                "《女性卵巢》论证翻译:海南出版社:海南出版社:郄亚楠%" +
                "EV-RE文档其余部分目录:中国汽车工程学会（亚莉/斯琪）:中国汽车工程学会:郑亚莉&赵斯琪%" +
                "蓝天幼儿艺术中心:德宏资本:德宏资本/三月资本:李忠军%" +
                "海水淡化:德宏资本:德宏资本/三月资本:李忠军%" +
                "《安全百科/情绪管理/笔》论证翻译3本:中青社:中国青年出版社:白峥%" +
                "《荷尔蒙》论证翻译:海南出版社:海南出版社:郄亚楠%" +
                "《花》论证翻译:海南出版社:海南出版社:郄亚楠%" +
                "《老年痴呆》论证翻译:海南出版社:海南出版社:郄亚楠%" +
                "ELISA Guidebook:农业部-动物疫病预防控制中心:农业部动物疫病预防控制中心:李鹏%" +
                "Yunnan METRU photo essay:UNICEF:UNICEF:张文%" +
                "上海问题:中国汽车工程学会（亚莉/斯琪）:中国汽车工程学会:郑亚莉&赵斯琪%" +
                "流浪兔（中译法）:伊可:个人:伊可%" +
                "日语（批量稿件）:中国汽车工程学会（亚莉/斯琪）:中国汽车工程学会:郑亚莉&赵斯琪%" +
                "手表翻译:手表:个人:Kwylauwy%" +
                "彩虹计划:中法水务-德润:德润:胡雨%" +
                "EV-RE项目论证:中国汽车工程学会（亚莉/斯琪）:中国汽车工程学会:郑亚莉&赵斯琪%" +
                "日语网页:中国汽车工程学会（亚莉/斯琪）:中国汽车工程学会:郑亚莉&赵斯琪%" +
                "UNICEF CHINA AT A GLANCE:UNICEF:UNICEF:张文%" +
                "亨德森ppt-Horizon Pan European Alpha Fund:亨德森:亨德森:Sunny&Charles%" +
                "流浪兔（中译英）:伊可:个人:伊可%" +
                "《机器人化的最前沿》:机械工业出版社:机械工业出版社:何士娟%" +
                "流浪兔（中译日）:伊可:个人:伊可%" +
                "重庆市水务资产经营有限公司情况简介:中法水务:苏伊士环境-德润:龚嘉怡Rachel%" +
                "APP Annie-试译（英译韩）:APP Annie:APP Annie:日语编辑小新%" +
                "APP Annie-试译（英译中）:APP Annie:APP Annie:日语编辑小新%" +
                "SWOT分析-试译:地产:个人:J%" +
                "病例翻译2:杨建西:个人:杨建西%" +
                "Why and how does UNICEF China use technology:UNICEF:UNICEF:张文%" +
                "4 things I learned as a UNICEF summer intern:UNICEF:UNICEF:张文%" +
                "新能源汽车技术发展情况:中国汽车工程学会（亚莉/斯琪）:中国汽车工程学会:郑亚莉&赵斯琪%" +
                "尽职调查问卷:亨德森:亨德森:Sunny&Charles%" +
                "CV:亨德森:亨德森:Sunny&Charles%" +
                "Child Focus on the SDGs-投资儿童:UNICEF:UNICEF:张文%" +
                "EV-RE表格:中国汽车工程学会（亚莉/斯琪）:中国汽车工程学会:郑亚莉&赵斯琪%" +
                "EV-RE Demo City:中国汽车工程学会（亚莉/斯琪）:中国汽车工程学会:郑亚莉&赵斯琪%" +
                "《不用药，养孩子》:海南出版社:海南出版社:郄亚楠%" +
                "SOWC补充翻译-第二次（80页）:UNICEF:UNICEF:张文%" +
                "CaaS:厘米脚印:厘米脚印:孙桥%" +
                "2016年可展望的6种CRM趋势:厘米脚印:厘米脚印:孙桥%" +
                "HIV/AIDS press release:UNICEF:UNICEF:张文%" +
                "7月3篇微信推送:厘米脚印:厘米脚印:孙桥%" +
                "EV-RE ANNEX A:中国汽车工程学会:中国汽车工程学会:陈敏%" +
                "中非：为医药监管合作铺平道路:UNOPS:UNOPS:陆瑞光%" +
                "议案3&6润色:中法水务-德润:德润:胡雨%" +
                "病例翻译1:杨建西:个人:杨建西%" +
                "曼联新闻稿 MU event press release:UNICEF:UNICEF:张文%" +
                "牛膝专论:中医院:中医院:中医院%" +
                "《一级方程式》2本:机械工业出版社:机械工业出版社:何士娟%" +
                "休斯顿合同:裴卫军:西安美康进出口有限公司:裴卫军%" +
                "EV-RE:中国汽车工程学会:中国汽车工程学会:陈敏%" +
                "筹备方案及章程 合作备忘录:中国汽车工程学会:中国汽车工程学会:陈敏%" +
                "The challenge of parenthood第二部分:Echo:个人:Echo%" +
                "吡拉西坦注射液:西安美康:西安美康进出口有限公司:裴卫军%" +
                "PPT-Isabel Nickel Project Corporate Presentation:AXIOM:AXIOM:刘用广Jeffrey%" +
                "2016世界儿童报告SOWC:UNICEF:UNICEF:张文%" +
                "《孩子一整天只上网》:机械工业出版社:机械工业出版社:何士娟%" +
                "Inequity is a Choice:UNICEF:UNICEF:张文%" +
                "Media Summary:UNICEF:UNICEF:张文%" +
                "Arcadis final longterm assumptions:中法水务:苏伊士环境-德润:龚嘉怡Rachel%" +
                "清华协议:UNICEF:UNICEF:张文%" +
                "The challenge of parenthood P185-244:Echo:个人:Echo%" +
                "Executive summary_Arcadis Final Report:中法水务:苏伊士环境-德润:龚嘉怡Rachel%" +
                "《迪士尼》5本:机械工业出版社:机械工业出版社:何士娟%" +
                "情锁三万英尺-介绍ppt:韵百年文化公司:北京韵百年文化传播有限公司:王伟迪&杨昕昕%" +
                "关于重钢葛老溪项目的投标情况总结与建议:中法水务-德润新邦:德润新邦:龙敏%" +
                "PPT-Management presentation:中法水务:苏伊士环境-德润:龚嘉怡Rachel%" +
                "3个visit memo:中法水务:苏伊士环境-德润:龚嘉怡Rachel%" +
                "《愚钝地活着/我们为何如此敏感》:机械工业出版社:机械工业出版社:何士娟%" +
                "北京峰会:工业设计中心-UNESCO:北京工业设计促进中心:张烨%" +
                "会议纪要 董事会第一次会议决议:中法水务-德润新邦:德润新邦:龙敏%" +
                "5月3篇微信推送:厘米脚印:厘米脚印:孙桥%" +
                "HIV EXPOSURE HANDBOOK:UNICEF:UNICEF:张文%" +
                "Arcadis Red Flags Report-KEMPS CREE:中法水务:苏伊士环境-德润:龚嘉怡Rachel%" +
                "Arcadis Red Flags Report（P29-57）:中法水务:苏伊士环境-德润:龚嘉怡Rachel%" +
                "晚餐陪同交传:韵百年文化公司:北京韵百年文化传播有限公司:王伟迪&杨昕昕%" +
                "产品介绍-补译:安洁奥医疗器械（北京）有限公司:安洁奥医疗器械（北京）有限公司:吕瑶Laura%" +
                "德润新邦葛老溪场地修复项目技术方案:中法水务-德润新邦:德润新邦:龙敏%" +
                "三会材料:中法水务-德润新邦:德润新邦:龙敏%" +
                "葛老溪-招标文件:中法水务-德润新邦:德润新邦:龙敏%" +
                "葛老溪-场地环境调查与风险评估报告:中法水务-德润新邦:德润新邦:龙敏%" +
                "情锁三万英尺-剧本1-5集:韵百年文化公司:北京韵百年文化传播有限公司:王伟迪&杨昕昕%" +
                "4月3篇微信推送:厘米脚印:厘米脚印:孙桥%" +
                "国际标准舞文化术语:Echo:个人:Echo%" +
                "情锁三万英尺-材料:韵百年文化公司:北京韵百年文化传播有限公司:王伟迪&杨昕昕%" +
                "2015司法改革报告:UNDP:UNDP:Ya Lou&Benjamin Moore&Zhang Yan&肖怡Sara&Shao Miaomiao%" +
                "流浪兔申请:伊可:个人:伊可%" +
                "产品介绍:安洁奥医疗器械（北京）有限公司:安洁奥医疗器械（北京）有限公司:吕瑶Laura%" +
                "《你和你的爱犬交流过吗》:机械工业出版社:机械工业出版社:何士娟%" +
                "流浪兔介绍:伊可:个人:伊可%" +
                "情锁三万英尺-简介:韵百年文化公司:北京韵百年文化传播有限公司:王伟迪&杨昕昕%" +
                "Venture Capital Financing:EB5:EB5 益博:朱文慧Catherine/Aleksandra%" +
                "能源互联网推进天然气改革和快速发展:石油工业出版社:石油工业出版社:高迎%" +
                "全口义齿-产品目录:安洁奥医疗器械（北京）有限公司:安洁奥医疗器械（北京）有限公司:吕瑶Laura%" +
                "Loan Review Mission:湖南省教育厅:湖南省教育厅:魏欣%" +
                "2本书-补充:农业部-动物疫病预防控制中心:农业部动物疫病预防控制中心:李鹏%" +
                "流浪兔问答:伊可:个人:伊可%" +
                "产品标签（法语）:乐其:Leqee乐其:姜海婷%" +
                "会议日程:湖南省教育厅:湖南省教育厅:魏欣%" +
                "2015年中国油气政策分析:石油工业出版社:石油工业出版社:高迎%" +
                "三会文件:中法水务-德润:德润:胡雨%" +
                "江格尔9-15集字幕（英）:大海:江格尔项目组:大海%" +
                "十三五人口报告:UNFPA:UNFPA:王岩%" +
                "江格尔主题曲:大海:江格尔项目组:大海";
        String[] sArr = s.split("%");
        System.out.println(sArr.length);
        Map<String, String> map = new HashMap<>();
        for(String str : sArr){
            String[] newArr = str.split(":");
            map.put(newArr[0] + newArr[1], str);
        }
        System.out.println(map.size());
        for(String str : map.keySet()){
            String newStr = map.get(str);
            String[] newStrArr = newStr.split(":");
            System.out.println("update w_project set customer_name = \""+newStrArr[2]+"-"+newStrArr[3]+"\"" +
                    " where project_name = \""+newStrArr[0]+"\" and customer_name = \""+newStrArr[1]+"\";");
        }


    }
}
