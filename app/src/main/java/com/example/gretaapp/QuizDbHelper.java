package com.example.gretaapp;

import static com.example.gretaapp.MainActivity.score;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "questions";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_QUESTION_TEXT = "question_text";
    public static final String COLUMN_OPTION1 = "option1";
    public static final String COLUMN_OPTION2 = "option2";
    public static final String COLUMN_OPTION3 = "option3";
    public static final String COLUMN_OPTION4 = "option4";
    public static final String COLUMN_CORRECT_OPTION = "correct_option";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY," +
                    COLUMN_QUESTION_TEXT + " TEXT," +
                    COLUMN_OPTION1 + " TEXT," +
                    COLUMN_OPTION2 + " TEXT," +
                    COLUMN_OPTION3 + " TEXT," +
                    COLUMN_OPTION4 + " TEXT," +
                    COLUMN_CORRECT_OPTION + " INTEGER" + ");";

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertQuestion(Question question) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION_TEXT, question.getQuestionText());
        values.put(COLUMN_OPTION1, question.getOption1());
        values.put(COLUMN_OPTION2, question.getOption2());
        values.put(COLUMN_OPTION3, question.getOption3());
        values.put(COLUMN_OPTION4, question.getOption4());
        values.put(COLUMN_CORRECT_OPTION, question.getCorrectOption());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Question> getAllQuestions() {
        List<Question> questionList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID)); // erreur mais ça marche
                String questionText = cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION_TEXT));
                String option1 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION1));
                String option2 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION2));
                String option3 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION3));
                String option4 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION4));
                int correctOption = cursor.getInt(cursor.getColumnIndex(COLUMN_CORRECT_OPTION));

                Question question = new Question(id, questionText, option1, option2, option3, option4, correctOption, score);
                questionList.add(question);
            } while (cursor.moveToNext());

            cursor.close();
        }
        db.close();
        return questionList;
    }
}
