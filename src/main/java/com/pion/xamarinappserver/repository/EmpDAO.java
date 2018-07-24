package com.pion.xamarinappserver.repository;

import com.pion.xamarinappserver.domain.Emp;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpDAO {
    private static List<Emp> emps;
    static {
        emps = new ArrayList<>();
        emps.add(new Emp(1001L, "leethyun", 6000L, "Chairman"));
        emps.add(new Emp(1002L, "leethyun1", 1000L, "C"));
        emps.add(new Emp(1003L, "leethyun2", 2000L, "Ch"));
        emps.add(new Emp(1004L, "leethyun3", 3000L, "Cha"));
        emps.add(new Emp(1005L, "leethyun4", 4000L, "Chai"));
        emps.add(new Emp(1006L, "leethyun5", 5000L, "Chair"));
        emps.add(new Emp(1007L, "leethyun6", 8000L, "Chairm"));
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public Emp getEmp(Long empno) {
        for (Emp e : emps)
            if (e.getEmpno().equals(empno)) return e;
        return null;
    }

    public Emp createEmp(Emp e) {
        emps.add(e);
        return e;
    }

    public Long deleteEmp(Long empno) {
        for (Emp e : emps)
            if (e.getEmpno().equals(empno)) {
                emps.remove(e);
                return empno;
            }
        return null;
    }

    public Emp updateEmp(Long empno, Emp e) {
        for (Emp emp : emps)
            if (e.getEmpno().equals(empno)) {
                e.setEmpno(emp.getEmpno());
                emps.remove(emp);
                emps.add(e);
                return e;
            }
        return null;
    }
}