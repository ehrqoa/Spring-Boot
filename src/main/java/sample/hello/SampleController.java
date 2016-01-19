package sample.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.hello.entity.Emp;
import sample.hello.repository.EmpRepository;

@Controller //コントローラーだよ、っていう定義
@EnableAutoConfiguration
public class SampleController {

@Autowired //リポジトリを紐づけます
EmpRepository repository;

@RequestMapping("/")
@ResponseBody
public Iterable<Emp> home(){

// 全件取得します
	Iterable<Emp> list = repository.findAll();

	// 取得した内容を出力します
	for(Emp emp: list){
	System.out.println(emp.getEmpID() + ":" + emp.getEmpName());
		}
		return list;//ここは気にしないでください。
//ないと怒られますので～。
	}
}
