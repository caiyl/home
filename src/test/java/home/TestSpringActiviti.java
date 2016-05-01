package home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import junit.framework.TestCase;

public class TestSpringActiviti extends TestCase {
	
	RepositoryService repositoryService;
	ProcessEngine processEngine;
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		repositoryService = (RepositoryService) ac.getBean("repositoryService");
		processEngine = (ProcessEngine) ac.getBean("processEngine");
		
	}
	
	
//	@Test
//	public void testDesp(){
//		
//		RepositoryService repositoryService = processEngine.getRepositoryService();
//		repositoryService.createDeployment()
//		  .addClasspathResource("diagrams/my-process.bpmn")
//		  .deploy();
//
//		System.out.println("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count());
//	}
	
//	@Test
//	public void testStartProc(){
//		Map<String, Object> variables = new HashMap<String, Object>();
//		variables.put("employeeName", "Kermit");
//		variables.put("numberOfDays", new Integer(4));
//		variables.put("vacationMotivation", "I'm really tired!");
//
//		RuntimeService runtimeService = processEngine.getRuntimeService();
//		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacationRequest", variables);
//
//		// Verify that we started a new process instance
//		System.out.println("Number of process instances: " + runtimeService.createProcessInstanceQuery().count());
//	}
//	
//	@Test
//	public void testTask(){
//		// Fetch all tasks for the management group
//		TaskService taskService = processEngine.getTaskService();
//		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
//		for (Task task : tasks) {
//			System.out.println("Task available: " + task.getName());
//		}
//		
//		Task task = tasks.get(0);
//
//		Map<String, Object> taskVariables = new HashMap<String, Object>();
//		taskVariables.put("vacationApproved", "false");
//		taskVariables.put("managerMotivation", "We have a tight deadline!");
//		taskService.complete(task.getId(), taskVariables);
//	}
	
	
}
