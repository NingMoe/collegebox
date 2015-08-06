package teacher;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.collegebox.teacher.config.AppConfig;
import com.collegebox.teacher.pojo.resource.Resource;
import com.collegebox.teacher.pojo.role.Role;
import com.collegebox.teacher.service.role.RoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("webapp")
@ContextConfiguration(classes = {AppConfig.class})
public class SimpleTest {
	
	@Autowired RoleService roleService;
	
	@Test
	public void roleTest() {
		
		Map<String,String> map = new LinkedHashMap<String,String>();
		List<Role> roles = roleService.getAllRoles();
		roles = roleService.loadResources(roles);
		for(Role role : roles) {
			String mark = role.getMark();
			for(Resource resource : role.getResources()) {
				String path = resource.getPath();
				if(map.containsKey(path)) {
					String existsMarks = map.get(path);
					map.put(path, existsMarks + "," + mark);
				} else {
					map.put(path, mark);
				}
			}
		}
		
		for(Map.Entry<String, String> entry:map.entrySet()){    
		     System.out.println(entry.getKey()+"--->"+entry.getValue());    
		} 
	}

}
