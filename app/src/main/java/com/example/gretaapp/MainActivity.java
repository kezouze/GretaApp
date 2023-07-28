package com.example.gretaapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Question> questionList;
    public static int score = 0;
    private static TextView scoreTextView;

    private List<Question> randomQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionList = new ArrayList<>();
        initializeQuestions();

        if (randomQuestions == null ) {
            randomQuestions = selectRandomQuestions(5);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        QuestionAdapter questionAdapter = new QuestionAdapter(randomQuestions);
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

        Question question21 = new Question(21, "Quel langage de programmation est utilisé pour créer des applications mobiles sur la plateforme iOS ?", "Swift", "Java", "Kotlin", "C#", 1, 5);
        questionList.add(question21);

        Question question22 = new Question(22, "Qu'est-ce que Git ?", "Un langage de programmation", "Un gestionnaire de bases de données", "Un système de contrôle de version", "Un logiciel de traitement de texte", 3, 5);
        questionList.add(question22);

        Question question23 = new Question(23, "Quel est l'outil principal utilisé pour écrire des requêtes SQL afin de manipuler des bases de données ?", "PhpMyAdmin", "MySQL", "SQLite", "DataGrip", 2, 5);
        questionList.add(question23);

        Question question24 = new Question(24, "Dans le développement web, quelle technologie est utilisée pour définir la présentation et la mise en forme des pages HTML ?", "XML", "CSS", "JSON", "HTML", 2, 5);
        questionList.add(question24);

        Question question25 = new Question(25, "Qu'est-ce qu'une boucle en programmation ?", "Un type de variable", "Une instruction pour arrêter l'exécution d'un programme", "Une séquence d'instructions répétée plusieurs fois", "Un type de fichier utilisé pour stocker des données", 3, 5);
        questionList.add(question25);

        Question question26 = new Question(26, "Quel langage de programmation est souvent utilisé pour le développement d'applications Android ?", "Java", "C#", "Python", "Ruby", 1, 5);
        questionList.add(question26);

        Question question27 = new Question(27, "Qu'est-ce qu'une clé primaire dans une base de données relationnelle ?", "Une colonne qui contient des valeurs uniques pour chaque enregistrement", "Une colonne qui stocke les valeurs numériques", "Une fonction permettant de trier les enregistrements dans l'ordre décroissant", "Une commande utilisée pour sauvegarder la base de données", 1, 5);
        questionList.add(question27);

        Question question28 = new Question(28, "Quelle est la différence entre un logiciel open source et un logiciel propriétaire ?", "Les logiciels open source sont gratuits, tandis que les logiciels propriétaires sont payants", "Les logiciels open source peuvent être modifiés et distribués librement, tandis que les logiciels propriétaires ont des restrictions", "Les logiciels open source sont plus sécurisés que les logiciels propriétaires", "Il n'y a aucune différence entre les deux types de logiciels", 2, 5);
        questionList.add(question28);

        Question question29 = new Question(29, "Qu'est-ce que l'algorithme de tri \"QuickSort\" ?", "Un algorithme de tri basé sur le principe \"diviser pour régner\"", "Un algorithme de tri qui utilise une liste chaînée pour organiser les éléments", "Un algorithme de tri utilisant une approche de tri par sélection", "Un algorithme de tri basé sur le principe de tri à bulles", 1, 5);
        questionList.add(question29);

        Question question30 = new Question(30, "Qu'est-ce qu'une \"classe\" en programmation orientée objet (POO) ?", "Un sous-programme qui effectue une tâche spécifique", "Un bloc d'instructions regroupées dans une fonction", "Une structure de données permettant de stocker des valeurs de différents types", "Un modèle utilisé pour créer des objets qui possèdent des propriétés et des méthodes", 4, 5);
        questionList.add(question30);

    }

    private List<Question> selectRandomQuestions(int count) {
        List<Question> copyQuestions = new ArrayList<>(questionList); // Copie de la liste originale
        Collections.shuffle(copyQuestions);
        return copyQuestions.subList(0, Math.min(count, copyQuestions.size()));
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
