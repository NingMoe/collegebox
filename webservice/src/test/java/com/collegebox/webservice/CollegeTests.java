package com.collegebox.webservice;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.collegebox.webservice.pojo.College;
import com.collegebox.webservice.pojo.Degree;
import com.collegebox.webservice.pojo.Major;
import com.collegebox.webservice.pojo.School;
import com.collegebox.webservice.repository.DegreeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CollegeTests {
	
	@Autowired
	DegreeRepository degreeRepository;
	
	@Test
	public void collegeTest() {
		
		College college1 = new College();
		
		college1.setArea("香港");
		college1.setCountry("中国");
		college1.setIntro("香港大学成立于 1911 年，由成立于 1887 年的香港西医书院和香港官立技术专科学校合并而成，是 香港历史最为悠久的大学 。"
				+ "中华民国国父孙中山先生就是香港西医书院的首届毕业生。 香港大学现建有建筑学院、文学院、经济及工商学院、牙医学院、教育学院、工学院、"
				+ "法学院、医学院、理学院、和社会科学学院 10 个学院，此外，还有研究生院、专业进修学院、数码港学院等其他教学单位，和亚洲研究中心、"
				+ "佛学研究中心等科研单位，传统的优势专业主要有 建筑、法律、生物工程、医学院、商学院、工程学系、以及社会科学学院的各种专业 。 "
				+ "香港大学的校训为 “ 明德格物 ”，并且一贯采用英语教学，在 人文、法律、政治、生物、"
				+ "医学等领域极为出色 ，在香港及亚洲地区都享有盛誉。香港大学是 Universities 21的创建成员之一， "
				+ "并且采用的教学模式为问题导向式学习，旨在培养学生的独立思考，所以在教学和科研上都享有国际声誉。 "
				+ "香港大学一向推崇 素质教育 ，特别鼓励学生参加对外交流，接触国外文化。香港大学的学生都是以小组的形式学习，并且 其毕业生的就业率、升学率、"
				+ "报酬水平上均为全港高校之冠 。");
		college1.setName("香港大学");
		college1.setSurrounding("暂无");
		
		School school11 = new School();
		school11.setName("经济管理学院");
		school11.setCollege(college1);
		
		Major major11 = new Major();
		major11.setName("经济学");
		major11.setSchool(school11);
		
		Degree degree11 = new Degree();
		degree11.setName("经济学硕士");
		degree11.setRequirements("学制1年，学费180,000港币， 9月开学 ， 雅思7.0（各项不低于6.5），托福90");
		degree11.setMajor(major11);
		
		/*******************************************************************************/
		
		School school12 = new School();
		school12.setName("工程学院");
		school12.setCollege(college1);
		
		Major major12 = new Major();
		major12.setName("计算机科学");
		major12.setSchool(school12);
		
		Degree degree12 = new Degree();
		degree12.setName("理学硕士");
		degree12.setRequirements("学制1-2年，相关专业背景，学费108,000港币， 9月开学 ， 雅思6.0（各项不低于5.5），托福80");
		degree12.setMajor(major12);
		
		/*******************************************************************************/
		
		College college2 = new College();
		
		college2.setArea("剑桥市");
		college2.setCountry("美国");
		college2.setIntro("哈佛大学（Harvard University），简称哈佛，坐落于美国马萨诸塞州剑桥市，是一所享誉世界的私立研究型大学，是著名的常春藤盟校成员。"
				+ "这里走出了8位美利坚合众国总统，上百位诺贝尔获得者曾在此工作、学习，其在文学、医学、法学、商学等多个领域拥有崇高的学术地位及广泛的影响力，"
				+ "被公认为是当今世界最顶尖的高等教育机构之一。哈佛同时也是美国本土历史最悠久的高等学府，其诞生于1636年，最早由马萨诸塞州殖民地立法机关创建，"
				+ "初名新市民学院，是为了纪念在成立初期给予学院慷慨支持的约翰•哈佛牧师。学校于1639年3月更名为哈佛学院。1780年，哈佛学院正式改称哈佛大学。"
				+ "截止2014年，学校有本科生6700余人，硕士及博士研究生14500余人。");
		college2.setName("哈佛大学");
		college2.setSurrounding("暂无");
		
		School school2 = new School();
		school2.setName("建筑学院");
		school2.setCollege(college2);
		
		Major major2 = new Major();
		major2.setName("建筑学");
		major2.setSchool(school2);
		
		Degree degree2 = new Degree();
		degree2.setName("建筑学硕士");
		degree2.setRequirements("托福总分92分以上（建议总分104分以上），单项不低于23分（建议单项26分以上），"
				+ "GRE阅读、数学和写作单项均分分别为158、157和4分，学费$43,700/年，申请截止日期12月15日");
		degree2.setMajor(major2);
		
		/*******************************************************************************/
		
		College college3 = new College();
		
		college3.setArea("伦敦");
		college3.setCountry("英国");
		college3.setIntro("牛津大学 是英国最负盛名的高等学府之一，是人类历史上最早出现的几所大学之一，建立于 13 世纪，以美丽的大学城闻名全世界，"
				+ "童话故事 --- 爱丽丝梦游仙境即以此地为故事背景。牛津大学是英国第一所国立大学 , 培育出无数的顶尖杰出人士。该校包含 36 个学院，"
				+ "除了各自有不同的建筑特色之外，每个学院为独立自主的教学机构，提供学生课业及生活上的指导。该大学共有 30 多个学院，各具特色。");
		college3.setName("牛津大学");
		college3.setSurrounding("暂无");
		
		School school3 = new School();
		school3.setName("赛德商学院");
		school3.setCollege(college3);
		
		Major major3 = new Major();
		major3.setName("金融经济学");
		major3.setSchool(school3);
		
		Degree degree3 = new Degree();
		degree3.setName("经济学硕士");
		degree3.setRequirements("学制1年，入学时间：9月，学费31,500英镑/年，雅思7.5（单项不低于7.0），"
				+ "托福110（口语不低于25，写作阅读不低于24，听力不低于22）");
		degree3.setMajor(major3);
		
		/*******************************************************************************/
		
		Set<Degree> degrees = new HashSet<Degree>();
		degrees.add(degree11);
		degrees.add(degree12);
		degrees.add(degree2);
		degrees.add(degree3);
		degreeRepository.save(degrees);
		
	}

}
