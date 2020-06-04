package com.example.MysqlAccess;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MysqlAccessController {
	@Autowired	// This means to get the bean called CustomerRepository
				// Which is auto-generated by Spring, we will use it to handle the data
	private CustomerRepository customerRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/")
    public String index() {
		// DBアクセスTop画面を表示
        return "index"; //目次
    }
	
	@GetMapping(path="/all") //データ一覧顧客名簿m_customer
	public String list(Model model) {
		// M_CUSTOMERテーブルの全データを取得
		Iterable<Customer> customerList = customerRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("customerlist",customerList);

		// データ一覧画面を表示
		return "list";
	}
	
	@RequestMapping("/insert") //データ登録画面m_customer
    public String insert() {
		// データ登録画面を表示
        return "insert";
    }
	
	// DB登録処理
	@PostMapping(path="/register")
	public @ResponseBody String addNewCustomer(	  @RequestParam String c_num 
												, @RequestParam String c_name
												, @RequestParam String address
												, @RequestParam String tel) {  //TEL追加
		
		Customer customerAddData = new Customer();
		customerAddData.setAll(c_num,c_name,address,tel); //TEL追加
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		customerAddData.setCreate_date(timestamp);
		customerAddData.setCreate_user("auto_system");
		customerAddData.setUpdate_date(timestamp);
		customerAddData.setUpdate_user("auto_system");
		
		customerRepository.save(customerAddData);
		
		return "登録しました";
	}
	
	@GetMapping(path="/data") //データ一覧部署名簿m_department
	public String data(Model model) {
		// M_department
		//テーブルの全データを取得
		Iterable<Department> departmentList = departmentRepository.findAll();
		
		// モデルに属性追加
		model.addAttribute("departmentlist",departmentList);

		// データ一覧画面を表示
		return "department_list.html";
	}
	
	@RequestMapping("/department_insert")//データ登録m_department
    public String plug(Model model) {
		// データ登録画面を表示
        return "department_insert";
   }

	
	// DB登録処理
		@PostMapping(path="/department_register")
		public @ResponseBody String addNewDepartment( @RequestParam String d_cd 
													, @RequestParam String d_name ){  
			
		Department departmentAddData = new Department();
		departmentAddData.setAll(d_cd, d_name); 
			
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		departmentAddData.setCreate_date(timestamp);
			departmentAddData.setCreate_user("auto_system");
			departmentAddData.setUpdate_date(timestamp);
			departmentAddData.setUpdate_user("auto_system");
			
			departmentRepository.save(departmentAddData);
			
		return "登録しました";
		}
		
		@GetMapping(path="/info") //データ一覧部署名簿m_employee
		public String info(Model model) {
			// M_department
			//テーブルの全データを取得
			Iterable<Employee> employeeList = employeeRepository.findAll();
			
			// モデルに属性追加
			model.addAttribute("employeelist",employeeList);

			// データ一覧画面を表示
			return "employee_list.html";
		}
		
		@RequestMapping("/employee_insert")
	    public String plug() {
			// データ登録画面を表示
	        return "employee_insert";
	    }
		
		// DB登録処理
			@PostMapping(path="/employee_register")
			public @ResponseBody String addNewEmployee(   @RequestParam String e_num 
														, @RequestParam String e_name
														, @RequestParam int e_year
														, @RequestParam String depart_cd){  
				
				Employee employeeAddData = new Employee();
				employeeAddData.setAll(e_num, e_name, e_year, depart_cd); 
				
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				employeeAddData.setCreate_date(timestamp);
				employeeAddData.setCreate_user("auto_system");
				employeeAddData.setUpdate_date(timestamp);
				employeeAddData.setUpdate_user("auto_system");
				
				employeeRepository.save(employeeAddData);
				
				return "登録しました";
			}
		
			
		
}
