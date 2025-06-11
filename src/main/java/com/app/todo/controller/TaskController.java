    package com.app.todo.controller;

    import com.app.todo.entity.Task;
    import com.app.todo.service.TaskService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @Controller
    @RequestMapping("/tasks")
    public class TaskController {

        @Autowired
        private  TaskService taskService;

        @GetMapping
        public String getTasks(Model model){
            List<Task> tasks = taskService.getAllTasks();
            model.addAttribute("tasks",tasks);
            return "tasks";
        }

        @PostMapping()
        public String createTask(@RequestParam String title){
            taskService.createTask(title);
            return "redirect:/tasks";
        }

        @GetMapping("/{id}/delete")
        public String deleteTask(@PathVariable Long id){
            taskService.deleteTask(id);
            return "redirect:/tasks";
        }

        @GetMapping("/{id}/finish")
        public String finishTask(@PathVariable Long id){
            taskService.finishTask(id);
            return "redirect:/tasks";
        }
    }
