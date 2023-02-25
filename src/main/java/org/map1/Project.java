package org.map1;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
    @Id
    private int pid;
    private String projectName;
    @ManyToMany(mappedBy = "projects")
    private List<Emp> emps;

    public Project(int pid, String projectName, List<Emp> emps) {
        this.pid = pid;
        this.projectName = projectName;
        this.emps = emps;
    }

    public Project() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
