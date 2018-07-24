package com.pion.xamarinappserver.controller;

import com.pion.xamarinappserver.domain.Emp;
import com.pion.xamarinappserver.repository.EmpDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/emp")
public class EmpController {
    @Autowired
    private EmpDAO empDAO;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Emp> getEmps() {
        return empDAO.getEmps();
    }

    @RequestMapping(value = "/{empno}", method = RequestMethod.GET)
    public ResponseEntity<Emp> getEmp(@PathVariable Long empno) {
        Emp e = empDAO.getEmp(empno);
        if (e == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity createEmp(@RequestBody Emp e) {
        empDAO.createEmp(e);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{empno}")
    public ResponseEntity deleteEmp(@PathVariable Long empno) {
        if (empDAO.deleteEmp(empno) != null) return new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/update/{empno}")
    public ResponseEntity<Emp> updateEmp(@PathVariable Long empno, @RequestBody Emp e) {
        e = empDAO.updateEmp(empno, e);
        if (e == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }
}
