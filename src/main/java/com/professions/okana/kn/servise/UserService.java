package com.professions.okana.kn.servise;

import com.professions.okana.kn.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    int avgUserAge();

    User findByEmail(String email);

    int countCourseMates(int courseName);

    List<User> showCourseMates();

    int countUniversityMates(String university);

    List<User> showUniversityMates();

    int countFacultyMates(String faculty);

    List<User> showFacultyMates();

    int countSubjectMates(String subject);

    List<User> showSubjectMates();

    List<User> theMostRatedUsers();

    int howManyLessonsUserHad (int userId);

    String averageTimeOfUserSingleMentoring(int userId);

}
