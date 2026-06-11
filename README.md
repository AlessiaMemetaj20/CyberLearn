# CyberLearn 🛡️📱

**CyberLearn** is a native Android application developed in **Kotlin** that helps users improve their cybersecurity awareness through interactive lessons and quizzes.

The application was created as a final project for the **New Programming Languages** course in the **Master of Science in Software Engineering** program at the **Canadian Institute of Technology (CIT)**.

---

## 🎯 Project Overview

Cybersecurity threats continue to increase worldwide, yet many users lack basic security knowledge. CyberLearn addresses this problem by providing short, easy-to-understand lessons on common cybersecurity topics and reinforcing learning through interactive quizzes.

The application focuses on four essential cybersecurity domains:

* 🎣 Phishing
* 🔐 Password Security
* 🎭 Social Engineering
* 🌐 Network Security

Each topic includes educational content followed by a multiple-choice quiz that provides immediate feedback and a final performance score.

---

## ✨ Features

### Educational Lessons

Users can browse cybersecurity topics and read concise, beginner-friendly lessons.

### Interactive Quizzes

Each lesson includes a five-question quiz designed to reinforce understanding.

### Instant Feedback

Correct and incorrect answers are highlighted immediately to enhance learning.

### Achievement Badges

Users receive motivational badges based on their final score.

### Share Results

Quiz results can be shared through any installed messaging or email application using Android's native sharing functionality.

### Offline Functionality

All educational content is bundled within the application and works without an internet connection.

### Privacy Friendly

No user accounts, personal information, or tracking mechanisms are used.

---

## 🏗️ Technologies Used

### Language

* Kotlin

### Android Components

* Activities
* Explicit Intents
* Implicit Intents
* RecyclerView
* ViewBinding
* Material Design Components
* ConstraintLayout
* LinearLayout
* ScrollView
* ImageView
* Toast Messages

### Architecture

* Repository Pattern
* Data Classes
* Singleton Objects
* ViewHolder Pattern
* Event-Driven Programming

---

## 📂 Project Structure

```text
app/
├── manifests/
│   └── AndroidManifest.xml

├── java/com/alessia/cyberlearn/
│   ├── MainActivity.kt
│   ├── LessonActivity.kt
│   ├── QuizActivity.kt
│   ├── adapters/
│   │   └── TopicAdapter.kt
│   ├── models/
│   │   ├── Topic.kt
│   │   └── Question.kt
│   └── data/
│       └── TopicRepository.kt

└── res/
    ├── layout/
    ├── drawable/
    ├── values/
    └── mipmap/
```

---

## 📱 Application Flow

1. User opens the application.
2. User selects a cybersecurity topic.
3. Lesson content is displayed.
4. User starts the quiz.
5. Immediate feedback is shown after each answer.
6. Final score and badge are displayed.
7. User can share the result or return to the home screen.

---

## 🔒 Security Awareness Topics

### Phishing

Learn how to recognize suspicious emails, links, and fraudulent websites.

### Password Security

Understand password best practices and the dangers of password reuse.

### Social Engineering

Identify manipulation techniques used by attackers to obtain sensitive information.

### Network Security

Learn the basics of safe browsing, HTTPS, Wi-Fi security, and online protection.

---

## 🚀 Future Improvements

Potential future enhancements include:

* User progress tracking
* Persistent score storage
* Albanian language localization
* Dark mode support
* Search functionality
* Audio narration
* Additional cybersecurity modules
* Gamification features

---

## 🎓 Academic Context

This project was developed as part of the:

**Course:** New Programming Languages
**Programme:** Master of Science in Software Engineering
**Institution:** Canadian Institute of Technology (CIT)
**Author:** Alessia Memetaj

---

## 📄 License

This project was created for educational purposes as part of an academic assignment.
