package com.professions.okana.kn.servise;

import com.professions.okana.kn.dao.UserDAOImpl;

import com.professions.okana.kn.model.User;
import com.professions.okana.kn.servise.CRUDService;
import com.professions.okana.kn.servise.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class UserServiceImpl implements CRUDService<User>, UserService {

    private final UserDAOImpl userDAO;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDAO = userDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User create(User user) {
        user.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getEncryptedPassword()));
        user.setCrearedAt(LocalDate.now());
        return userDAO.create(user);
    }

    @Override
    public User update(User user) {
        return userDAO.update(user);
    }

    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

    @Override
    public int avgUserAge() {
        return userDAO.avgUserAge();
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public int countCourseMates(int courseName) {
        return userDAO.countCourseMates(courseName);
    }

    @Override
    public List<User> showCourseMates() {
        return userDAO.showCourseMates();
    }

    @Override
    public int countUniversityMates(String university) {
        return userDAO.countUniversityMates(university);
    }

    @Override
    public List<User> showUniversityMates() {
        return userDAO.showUniversityMates();
    }

    @Override
    public int countFacultyMates(String faculty) {
        return userDAO.countFacultyMates(faculty);
    }

    @Override
    public List<User> showFacultyMates() {
        return userDAO.showFacultyMates();
    }

    @Override
    public int countSubjectMates(String subject) {
        return userDAO.countSubjectMates(subject);
    }

    @Override
    public List<User> showSubjectMates() {
        return userDAO.showSubjectMates();
    }

    @Override
    public List<User> theMostRatedUsers() {
        return userDAO.theMostRatedUsers();
    }

    @Override
    public int howManyLessonsUserHad(int userId) {
        return userDAO.howManyLessonsUserHad(userId);
    }

    @Override
    public String averageTimeOfUserSingleMentoring(int userId) {
        return userDAO.averageTimeOfUserSingleMentoring(userId);
    }
}
