package model;
//第二个代码模型
//
class Dept{
    private int deptno;
    private String dname;
    private String loc;
    private Emp emps[]; //多个雇员

    public Dept(){}
    public Dept(int deptno,String dname,String loc){
            this.deptno = deptno;
            this.dname = dname;
            this.loc = loc;
    }

    public void setEmps(Emp emps []){
        this.emps = emps;
    }

    public Emp[] getEmps() {
        return this.emps;
    }


    public String getInfo() {
        return "部门编号:"+this.deptno+"部门名字:"+this.dname+"部门位置:"+this.loc;
    }
}

class Emp{
    private int empno;
    private String ename;
    private String job;
    private double sal;
    private double comm;
    private Dept dept; //一个部门
    private Emp mgr; //一个领导

    public Emp(){}
    public Emp(int empno,String ename,String job,double sal,double comm){
            this.empno = empno;
            this.ename = ename;
            this.job = job;
            this.sal = sal;
            this.comm = comm;
    }

    public void setDept(Dept dept){
        this.dept = dept;
    }
    public Dept getDept(){
        return this.dept;
    }
    public void setMgr(Emp mgr){
        this.mgr = mgr;
    }
    public Emp getMgr(){
        return this.mgr;
    }
    public String getInfo() {
        return "雇员编号:"+this.empno+"\n"+"雇员姓名:"+this.ename+"\n"+"雇员职业:"+this.job+"\n"+"佣金:"+this.sal+"\n"+"基本工资:"+this.comm+"\n"+"==========================================";
    }
}

public class TypeTwo {
    public static void main(String args[]){
        Dept dept = new Dept(1001,"Acount","NewYork");
        Dept dept2 = new Dept(1002,"YJY","hangzhou");
        Emp ea = new Emp(1111,"wang","clear",233.00,2000.00);
        Emp eb = new Emp(1112,"xia","js",133.00,3000.00);
        Emp ec = new Emp(1113,"lin","java",321,4000.00);
        Emp ed = new Emp(1114,"yu","python",399.00,5000.00);
        //设置雇员和领导的关系
        ea.setMgr(eb);
        eb.setMgr(ec);
        //设置雇员和部门的关系
        ea.setDept(dept);
        eb.setDept(dept);
        ec.setDept(dept);
        ec.setDept(dept2);
        //设置部门和雇员的关系
        dept.setEmps(new Emp[]{ea,eb,ec});

        //System.out.println(ea.getMgr().getInfo());
        for (int x = 0;x<dept.getEmps().length;x++){
          //  System.out.println(dept.getEmps()[x].getInfo());
            if (dept.getEmps()[x].getMgr() != null){
                System.out.println(dept.getEmps()[x].getMgr().getInfo());
            }
        }

    }
}
