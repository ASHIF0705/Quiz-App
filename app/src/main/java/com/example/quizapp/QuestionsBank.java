package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    public static List<Question> getQuestions(String category) {
        List<Question> list = new ArrayList<>();

        if (category.equals("sports")) {
            // 15 Sports Questions
            list.add(new Question("Who won the FIFA World Cup 2022?",
                    new String[]{"France", "Brazil", "Argentina", "Germany"}, 2));
            list.add(new Question("Which country has won the most Cricket World Cups?",
                    new String[]{"India", "West Indies", "Australia", "England"}, 2));
            list.add(new Question("How many players are there in a football team on the field?",
                    new String[]{"10", "11", "12", "9"}, 1));
            list.add(new Question("Who is known as the 'Fastest Man on Earth'?",
                    new String[]{"Carl Lewis", "Usain Bolt", "Jesse Owens", "Michael Johnson"}, 1));
            list.add(new Question("In which sport is the term 'Grand Slam' used?",
                    new String[]{"Football", "Cricket", "Tennis", "Golf"}, 2));
            list.add(new Question("Which IPL team has won the most titles till 2024?",
                    new String[]{"Mumbai Indians", "Chennai Super Kings", "Kolkata Knight Riders", "Gujarat Titans"}, 1));
            list.add(new Question("Who holds the record for most goals in football history?",
                    new String[]{"Pele", "Lionel Messi", "Cristiano Ronaldo", "Diego Maradona"}, 2));
            list.add(new Question("Olympic Games are held every how many years?",
                    new String[]{"2 years", "4 years", "5 years", "6 years"}, 1));
            list.add(new Question("Which country won the most medals in Tokyo Olympics 2020?",
                    new String[]{"China", "USA", "Japan", "Russia"}, 1));
            list.add(new Question("In badminton, what is the name of the shot that goes just over the net?",
                    new String[]{"Smash", "Drop", "Drive", "Lob"}, 1));
            list.add(new Question("Who is the captain of Indian Cricket Team in Tests (2025)?",
                    new String[]{"Virat Kohli", "Rohit Sharma", "Jasprit Bumrah", "Shubman Gill"}, 1));
            list.add(new Question("Which sport uses the term 'Hole in One'?",
                    new String[]{"Golf", "Tennis", "Cricket", "Baseball"}, 0));
            list.add(new Question("How many rings are there in the Olympic symbol?",
                    new String[]{"4", "5", "6", "7"}, 1));
            list.add(new Question("Who won the Wimbledon Men's Singles 2024?",
                    new String[]{"Novak Djokovic", "Carlos Alcaraz", "Jannik Sinner", "Roger Federer"}, 1));
            list.add(new Question("In which sport is 'Bulldog' a term used?",
                    new String[]{"Rugby", "Wrestling", "Boxing", "Swimming"}, 1));
        }
        else if (category.equals("gk")) {
            // 15 General Knowledge Questions
            list.add(new Question("What is the capital of Australia?",
                    new String[]{"Sydney", "Melbourne", "Canberra", "Perth"}, 2));
            list.add(new Question("Which is the largest planet in our solar system?",
                    new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 2));
            list.add(new Question("Who painted the Mona Lisa?",
                    new String[]{"Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Michelangelo"}, 2));
            list.add(new Question("How many continents are there on Earth?",
                    new String[]{"5", "6", "7", "8"}, 2));
            list.add(new Question("Which gas do plants absorb from the atmosphere?",
                    new String[]{"Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"}, 2));
            list.add(new Question("Who is known as the Father of the Indian Constitution?",
                    new String[]{"Mahatma Gandhi", "Jawaharlal Nehru", "B.R. Ambedkar", "Sardar Patel"}, 2));
            list.add(new Question("What is the currency of Japan?",
                    new String[]{"Yuan", "Won", "Yen", "Rupee"}, 2));
            list.add(new Question("Which is the longest river in the world?",
                    new String[]{"Amazon", "Nile", "Yangtze", "Mississippi"}, 1));
            list.add(new Question("In which year did India gain independence?",
                    new String[]{"1945", "1947", "1950", "1942"}, 1));
            list.add(new Question("Who invented the telephone?",
                    new String[]{"Thomas Edison", "Alexander Graham Bell", "Nikola Tesla", "Albert Einstein"}, 1));
            list.add(new Question("What is the smallest country in the world by land area?",
                    new String[]{"Monaco", "Vatican City", "San Marino", "Liechtenstein"}, 1));
            list.add(new Question("Which element has the chemical symbol 'O'?",
                    new String[]{"Gold", "Silver", "Oxygen", "Iron"}, 2));
            list.add(new Question("Who wrote 'Romeo and Juliet'?",
                    new String[]{"Charles Dickens", "William Shakespeare", "Mark Twain", "Jane Austen"}, 1));
            list.add(new Question("What is the hardest natural substance on Earth?",
                    new String[]{"Gold", "Iron", "Diamond", "Platinum"}, 2));
            list.add(new Question("Which animal is known as the 'Ship of the Desert'?",
                    new String[]{"Horse", "Camel", "Elephant", "Lion"}, 1));
        }
        else if (category.equals("programming")) {
            // 15 Programming Questions (Python, HTML, Java mixed)
            list.add(new Question("Who created Python programming language?",
                    new String[]{"Guido van Rossum", "Dennis Ritchie", "James Gosling", "Brendan Eich"}, 0));
            list.add(new Question("What is the correct file extension for Python files?",
                    new String[]{".java", ".py", ".html", ".js"}, 1));
            list.add(new Question("Which keyword is used to define a function in Python?",
                    new String[]{"func", "define", "def", "function"}, 2));
            list.add(new Question("What does HTML stand for?",
                    new String[]{"Hyper Text Markup Language", "High Tech Modern Language", "Hyper Transfer Markup Language", "Home Text Markup Language"}, 0));
            list.add(new Question("Which tag is used to create a hyperlink in HTML?",
                    new String[]{"<link>", "<a>", "<href>", "<url>"}, 1));
            list.add(new Question("Who developed Java programming language?",
                    new String[]{"Microsoft", "Sun Microsystems", "Google", "Apple"}, 1));
            list.add(new Question("What is the main method signature in Java?",
                    new String[]{"public void main(String args)", "public static void main(String[] args)", "static void main()", "void main(String[] args)"}, 1));
            list.add(new Question("Which symbol is used for single-line comments in Python?",
                    new String[]{"//", "/*", "#", "<!--"}, 2));
            list.add(new Question("In HTML, which tag is used for the largest heading?",
                    new String[]{"<h6>", "<h1>", "<head>", "<heading>"}, 1));
            list.add(new Question("What is the output of print(2 ** 3) in Python?",
                    new String[]{"6", "8", "9", "16"}, 1));
            list.add(new Question("Which company originally developed Java?",
                    new String[]{"Oracle", "Sun Microsystems", "IBM", "Microsoft"}, 1));
            list.add(new Question("In Python, which data type is used to store a sequence of characters?",
                    new String[]{"int", "float", "str", "list"}, 2));
            list.add(new Question("Which HTML attribute is used to define inline styles?",
                    new String[]{"class", "id", "style", "font"}, 2));
            list.add(new Question("What does JVM stand for in Java?",
                    new String[]{"Java Virtual Machine", "Java Visual Machine", "Java Variable Machine", "Java Verified Machine"}, 0));
            list.add(new Question("Which of these is not a Python data type?",
                    new String[]{"list", "tuple", "dictionary", "class"}, 3));
        }

        return list;
    }
}

class Question {
    String questionText;
    String[] options;
    int correctAnswer; // 0 to 3

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}