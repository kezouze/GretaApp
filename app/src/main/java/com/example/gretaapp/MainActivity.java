package com.example.gretaapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Question> questionList;
    public static int score = 0;
    private static TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionList = new ArrayList<>();
        initializeQuestions();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        QuestionAdapter questionAdapter = new QuestionAdapter(questionList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(questionAdapter);
        scoreTextView = findViewById(R.id.scoreTextView);
        findViewById(R.id.btnShowScore).setOnClickListener(v -> showScore());
    }
    private void initializeQuestions() {
        Question question1 = new Question(1, "Comment procéder pour envoyer le même courriel à trois personnes sans qu'elles connaissent l'existence des autres destinataires ?", "On place une adresse différente dans chaque champ : A, Cc et Cci.", "On place toutes les adresses dans le champ A.", "On place toutes les adresses dans le champ Cc.", "On place toutes les adresses dans le champ Cci.", 4, 5);
        questionList.add(question1);

        Question question2 = new Question(2, "Que caractérise l'adresse IP ?", "Le code secret pour administrer un ordinateur.", "Le numéro de série d'un ordinateur.", "Le débit d'une connexion à Internet.", "L'adresse d'un ordinateur connecté au réseau.", 4, 5);
        questionList.add(question2);

        Question question3 = new Question(3, "Un fichier localisé sur un disque dur peut-être \"caché\". Qu'est-ce que cela implique ?","Le fichier est localisé dans le cache du navigateur.","Le fichier peut ne pas être affiché dans le gestionnaire de fichiers.", "Le fichier est compressé.", "L'ouverture du fichier requiert un mot de passe.", 2, 5);
        questionList.add(question3);

        Question question4 = new Question(4, "Qu'est-ce l'agenda partagé d'un groupe ?", "Un calendrier regroupant les évènements intéressant le groupe.","Un outil de sondage permettant de trouver une date commune pour planifier un évènement.", "Un carnet d'adresses regroupant les adresses électroniques du groupe.", "Un répertoire présentant par ordre alphabétique les membres du groupe.", 1, 5);
        questionList.add(question4);

        Question question5 = new Question(5, "Comment nommer judicieusement les lettres de relance successives que l'on peut envoyer à un collaborateur si on veut pouvoir les trier pour qu'elles s'affichent par ordre croissant de date de relance ?", "Relance_29_nov_2022.odt", "Relance_29_11_2022.odt", "Relance_2022_11_29.odt", "Relance_2022_nov_29.odt", 3, 5);
        questionList.add(question5);

        Question question6 = new Question(6, "Qu'est-ce qu'un langage de programmation ?", "Un logiciel pour créer des sites web.", "Un ensemble d'instructions pour communiquer avec un ordinateur.", "Un outil pour gérer une base de données.", "Un navigateur web pour tester des applications.", 2, 5);
        questionList.add(question6);

        Question question7 = new Question(7, "Quelle est la signification de l'acronyme HTML ?", "HyperText Markup Language", "Home Tool Markup Language", "Hyperlink and Text Markup Language", "High-level Text Markup Language", 1, 5);
        questionList.add(question7);

        Question question8 = new Question(8, "Quel langage est utilisé pour rendre les pages web interactives ?", "HTML", "CSS", "JavaScript", "Java", 3, 5);
        questionList.add(question8);

        Question question9 = new Question(9, "Quelle balise HTML est utilisée pour créer un lien hypertexte ?", "<a>", "<link>", "<href>", "<url>", 1, 5);
        questionList.add(question9);

        Question question10 = new Question(10, "Quelle est la signification de l'acronyme CSS ?", "Computer Style Sheets", "Creative Style Sheets", "Cascading Style Sheets", "Colorful Style Sheets", 3, 5);
        questionList.add(question10);

        Question question11 = new Question(11, "Quel langage est principalement utilisé pour styliser les pages web ?", "HTML", "Python", "CSS", "JavaScript", 3, 5);
        questionList.add(question11);

        Question question12 = new Question(12, "Quelle balise HTML est utilisée pour définir le titre d'une page web affiché dans la barre de titre du navigateur ?", "<title>", "<header>", "<h1>", "<head>", 1, 5);
        questionList.add(question12);

        Question question13 = new Question(13, "Quel langage de programmation est souvent utilisé pour créer des applications web côté serveur ?", "Python", "C#", "Java", "PHP", 4, 5);
        questionList.add(question13);

        Question question14 = new Question(14, "Quelle balise HTML est utilisée pour insérer une image sur une page web ?", "<img>", "<picture>", "<image>", "<src>", 1, 5);
        questionList.add(question14);

        Question question15 = new Question(15, "Quel acronyme représente le modèle de développement des applications mobiles pour Android ?", "SDK", "IDE", "APK", "MVC", 4, 5);
        questionList.add(question15);

        Question question16 = new Question(16, "Quelle est la signification de l'acronyme SQL ?", "Structured Query Language", "Simple Query Language", "System Query Language", "Structured Question Language", 1, 5);
        questionList.add(question16);

        Question question17 = new Question(17, "Quel langage est utilisé pour interagir avec une base de données ?", "Python", "JavaScript", "Java", "SQL", 4, 5);
        questionList.add(question17);

        Question question18 = new Question(18, "Quelle balise HTML est utilisée pour créer une liste à puces ?", "<ol>", "<li>", "<ul>", "<list>", 3, 5);
        questionList.add(question18);

        Question question19 = new Question(19, "Quelle est la signification de l'acronyme PHP ?", "Personal Hypertext Processor", "Hypertext Markup Processor", "PHP: Hypertext Preprocessor", "Preprocessed Hypertext Pages", 3, 5);
        questionList.add(question19);

        Question question20 = new Question(20, "Quel langage est utilisé pour définir la structure et le contenu d'une page web ?", "HTML", "CSS", "JavaScript", "PHP", 1, 5);
        questionList.add(question20);

    }

    private void showScore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Score")
                .setMessage("Vous avez obtenu " + score + " points !")
                .setPositiveButton("OK", (dialog, which) -> {
                    score = 0;
                    updateScoreTextView();
                    dialog.dismiss();
                })
                .setCancelable(false)
                .show();
    }

    public static void updateScoreTextView() {
        scoreTextView.setText("Score " + score);
    }
}
