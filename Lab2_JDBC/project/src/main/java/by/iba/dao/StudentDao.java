package by.iba.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import by.iba.model.Student;
import java.sql.SQLIntegrityConstraintViolationException;
import java.math.BigDecimal;
import java.sql.Date;

public class StudentDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int st;//status

    public int insert(Student student) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into student(fname,lname,address,mobileNo,mailId,city,designation,dob,doj,salary) "
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, student.getFname());
            ps.setString(2, student.getLname());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getMobileNo());
            ps.setString(5, student.getMailId());
            ps.setString(6, student.getCity());
            ps.setString(7, student.getDesignation());
            ps.setDate(8, student.getDob());
            ps.setDate(9, student.getDoj());
            ps.setBigDecimal(10, student.getSalary());
            st = ps.executeUpdate();
            System.out.println("inserted student " + st);
        } catch (SQLIntegrityConstraintViolationException e) {
            st = -1;
            e.printStackTrace();
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public int update(Student student) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "update student set fname=?,lname=?,address=?,mobileNo=?,mailId=?,city=?, "
                    + "designation=?,dob=?,doj=?,salary=? "
                    + "where id=? ";
            ps = con.prepareStatement(query);
            ps.setString(1, student.getFname());
            ps.setString(2, student.getLname());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getMobileNo());
            ps.setString(5, student.getMailId());
            ps.setString(6, student.getCity());
            ps.setString(7, student.getDesignation());
            ps.setDate(8, student.getDob());
            ps.setDate(9, student.getDoj());
            ps.setBigDecimal(10, student.getSalary());
            ps.setLong(11, student.getId());
            st = ps.executeUpdate();
            System.out.println("updated student " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public int delete(long id) {
        con = ConnectionFactory.getConnection();
        try {
            String query = "delete from student where id=? ";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            st = ps.executeUpdate();
            System.out.println("deleted student " + st);
        } catch (Exception e) {
            st = -2;
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return st;
    }

    public Student fetchById(long id) {
        Student student = new Student();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where id=?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobileNo"));
                student.setMailId(rs.getString("mailId"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("addDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return student;
    }

    public Student fetchByEmailId(String mailId) {
        Student student = new Student();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where mailId=?";
            ps = con.prepareStatement(query);
            ps.setString(1, mailId);
            rs = ps.executeQuery();
            while (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobileNo"));
                student.setMailId(rs.getString("mailId"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("addDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return student;
    }

    public Student fetchByMobileNo(String mobileNo) {
        Student student = new Student();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where mobileNo=?";
            ps = con.prepareStatement(query);
            ps.setString(1, mobileNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobileNo"));
                student.setMailId(rs.getString("mailId"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("addDate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return student;
    }

    // Найти студентов по Имени
    // Модернизируйте метод. С возможностью искать и по имени и по фамилии с помощью слова like
    public List<Student> fetchByName(String fname) {
        List<Student> studentList = new ArrayList<Student>();
        con = ConnectionFactory.getConnection();
        try {
            //String query = "select * from student where fname=?";
            String query = "select * from student where fname like ? or lname like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, fname);
            ps.setString(2, fname);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobileNo"));
                student.setMailId(rs.getString("mailId"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("addDate"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchByCity(String city) {
        List<Student> studentList = new ArrayList<Student>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where  city=?";
            ps = con.prepareStatement(query);
            ps.setString(1, city);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobileNo"));
                student.setMailId(rs.getString("mailId"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("addDate"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    // Найти студентов с ЗП в пределах От и До
    public List<Student> fetchBySalaryRange(BigDecimal lowerSalary, BigDecimal higherSalary) {
        List<Student> studentList = new ArrayList<Student>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where salary BETWEEN ? AND ?";
            ps = con.prepareStatement(query);
            ps.setBigDecimal(1, lowerSalary);
            ps.setBigDecimal(2, higherSalary);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobileNo"));
                student.setMailId(rs.getString("mailId"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("addDate"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchByDob(Date dob) {
        List<Student> studentList = new ArrayList<Student>();

        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where dob=?";
            ps = con.prepareStatement(query);
            ps.setDate(1, dob);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobileNo"));
                student.setMailId(rs.getString("mailId"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("addDate"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    // Найти студентов с датами От и До
    public List<Student> fetchByRangeDoj(Date startDate, Date endDate) {
        List<Student> studentList = new ArrayList<Student>();

        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where doj BETWEEN ? AND ?";
            ps = con.prepareStatement(query);
            ps.setDate(1, new java.sql.Date(startDate.getTime()));
            ps.setDate(2, new java.sql.Date(endDate.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobileNo"));
                student.setMailId(rs.getString("mailId"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("addDate"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    public List<Student> fetchAll() {
        List<Student> studentList = new ArrayList<Student>();

        con = ConnectionFactory.getConnection();
        try {

            // Модернизируйте поиск - отсортировав от большего к меньшему по полю id


            String query = "select * from student";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobileNo"));
                student.setMailId(rs.getString("mailId"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("addDate"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }
}