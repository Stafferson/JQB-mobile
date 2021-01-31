package com.example.jqb_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class test1_activity extends AppCompatActivity {

    PieChart pieChart;
    PieData pieData;
    List<PieEntry> pieEntryList = new ArrayList<>();
    int counter;
    int counter2;
    Button bt_plus_plus, bt_plus, bt_ntral, bt_no, bt_no_no;
    TextView question;
    PieDataSet pieDataSet;
    String[][][] test = {{{"learning about the lives of plants and animals."}, {"Biology",}},{{"Lessons of geography, reading textbook of geography."}, {"Geography","Geology",}},{{"Read fiction or non-fiction on geological expeditions."}, {"Geography","Geology",}},{{"the Lessons and textbook of anatomy and physiology of human."}, {"Biology","Medicine","Physics","Physical education and sport",}},{{"Lessons of Economics or homework Economics."}, {"Mathematics","Economics",}},{{"to Read non-fiction about the physical discoveries about the life and activities of prominent physicists."}, {"Physics","Chemistry","History",}},{{"to Read about the discoveries in chemistry, or the life and activities of prominent chemists."}, {"Physics","Chemistry","History",}},{{"to get Acquainted with different metals and their properties."}, {"metal","Physics","Chemistry","Engineering",}},{{"to Learn about the achievements in the field of construction."}, {"Construction","the service Sector, manufacturing",}},{{"to Meet with military equipment."}, {"Military law","Physics","Mathematics",}},{{"Read books about historical events and historical figures."}, {"History",}},{{"to Read the classics of English and foreign literature."}, {"Literature",}},{{"to Read and discuss newspaper and magazine articles and essays."}, {"Journalism",}},{{"Read books, watch films about the work of the police."}, {"Military law","Right, law",}},{{"Read books like 'Entertaining mathematics', 'Mathematical mind'."}, {"Mathematics",}},{{"Learn of economic geography."}, {"Geography","Economics",}},{{"Lessons of foreign language."}, {"Foreign languages",}},{{"learning about the lives of famous artists, the history of the fine arts."}, {"History","Visual arts",}},{{"to get Acquainted with the life of the outstanding masters of the stage and cinema, to meet the artists, to collect their photos."}, {"Stage art",}},{{"to get Acquainted with the life and work of outstanding musicians, with the theory of music."}, {"Music",}},{{"to Read sports magazines, Newspapers, books about sports, about famous athletes."}, {"Physical education and sport",}},{{"to Study biology, botany, Zoology."}, {"Biology",}},{{"to Learn about different countries and geographical discovery."}, {"Geography","Geology",}},{{"to Read about the life and work of the famous geologists."}, {"Geology",}},{{"to Read about how people have learned to fight diseases, the doctors and achievements in the field of medicine."}, {"Medicine",}},{{"to Visit the enterprises of light industry."}, {"Economics",}},{{"Find chemical phenomena in nature, to make tests in chemistry, to monitor the progress of chemical reactions."}, {"Chemistry","Medicine",}},{{"to Visit a radio or a mug to get acquainted with the work of an electrician."}, {"Physics","electrical and radio engineering",}},{{"to Meet different measuring tools for the Metalworking and to work with them."}, {"metal",}},{{"to Observe the manufacture of products of wood, to consider new pieces of furniture."}, {"woodworking",}},{{"to Meet with the builders, to watch them at work."}, {"Construction","the service Sector, manufacturing",}},{{"Reading books, watching movies about the military, to get acquainted with the history of war, major battles."}, {"Military law","History",}},{{"to Read literary-critical articles."}, {"Journalism","Literature",}},{{"to Learn about the events happening in the city, the country, country."}, {"Journalism","Economics",}},{{"to explain the companions how to perform the exercise, if they can't do it themselves."}, {"Physical education and sport",}},{{"to Provide for the family products; to organize food for all during the campaign."}, {"Public activities",}},{{"to Read non-fiction about the discoveries in mathematics, about the life and activities of prominent mathematicians."}, {"Mathematics",}},{{"Interested in the implementation of economic plans."}, {"Economics",}},{{"to Read fiction in a foreign language."}, {"Foreign languages",}},{{"to Be a member of the editorial Board, to engage in artistic design of the Newspapers."}, {"Journalism",}},{{"Visit drama theatre or theatre for young audiences."}, {"Stage art",}},{{"listen to the Opera or the Symphony."}, {"Stage art",}},{{"to Attend sporting events, to watch and listen to sports radio and television."}, {"Physical education and sport",}},{{"to Visit the biological circle."}, {"Biology",}},{{"to Engage in a geographic circle."}, {"Geography",}},{{"Compile and gather descriptions and images of geologic features of the earth minerals."}, {"Geology",}},{{"to Study the functions of the human body, the causes of diseases and treatment methods."}, {"Biology","Medicine",}},{{"to Carry out experiments in physics."}, {"Physics",}},{{"Cooking solutions, to weigh chemicals."}, {"Chemistry",}},{{"be Disassembled and repaired by different mechanisms (e.g., clock, iron)."}, {"Engineering",}},{{"the Use of precise measuring equipment (oscilloscope, voltmeter, ammeter); to produce a variety of calculations."}, {"metal","woodworking","Engineering","Mathematics","Physics","Chemistry",}},{{"to Make various items and parts made of metal."}, {"metal",}},{{"to Make various items and parts made of wood or artistic processing of wood."}, {"woodworking",}},{{"to Sketch building sketch, or to carry out plans of various buildings."}, {"Construction",}},{{"to Engage in the shooting section."}, {"Military law",}},{{"to Study the history of various peoples and States."}, {"History",}},{{"Writing cool and Pets essays for literature."}, {"Literature",}},{{"Watch out for actions, behavior, other people's lives."}, {"Journalism",}},{{"to Perform public work, organize, rally comrades in any case."}, {"Public activities",}},{{"Spending time with young children, read books, anything to tell them, to help anything."}, {"Public activities",}},{{"to Study the development of the industry, learn about new advances in the field of planning and accounting in an industrial plant."}, {"Construction","the service Sector, manufacturing",}},{{"Working with foreign dictionaries to understand the figures of speech of an unfamiliar language."}, {"Foreign languages",}},{{"being on stage in front of the audience."}, {"Stage art",}},{{"to Play a musical instrument."}, {"Music",}},{{"to Play sports."}, {"Physical education and sport",}},{{"to Observe the growth and development of animals, plants, keep records of observations."}, {"Biology",}},{{"create geographic maps, collect different geographical materials."}, {"Geography",}},{{"Collecting minerals, exhibits geological Museum."}, {"Geology",}},{{"Acquainted with the work of the physician, nurse, pharmacist."}, {"Medicine",}},{{"Engage in the physics club, or take some classes in physics."}, {"Physics",}},{{"to Engage in chemical mug or visit electives in chemistry."}, {"Chemistry",}},{{"Lessons of labor in school and fitting and machining workshops."}, {"Engineering",}},{{"to Participate in military games."}, {"Military law",}},{{"to Visit historical museums, to get acquainted with the monuments of culture."}, {"History",}},{{"to Engage in the literary circle, take some classes in literature or foreign language."}, {"Literature","Foreign languages",}},{{"keep a personal diary."}, {"Literature",}},{{"to find Out the reasons for the behavior and actions of people that they want to hide."}, {"Right, law",}},{{"to Help the buyer to choose a purchase at the store that he needs."}, {"Economics",}},{{"BUT. To solve complex problems in mathematics."}, {"Mathematics",}},{{"Just to calculate their costs and revenues."}, {"Economics",}},{{"to Engage in the circle foreign language or take some classes."}, {"Foreign languages",}},{{"to Engage in the artistic circle."}, {"Visual arts",}},{{"to Engage in the choir or in the music circle."}, {"Music",}},{{"to Engage in any sports section."}, {"Physical education and sport",}},{{"Participate in biological Olympics, or prepare an exhibition of plants or animals."}, {"Biology",}},{{"to Participate in a geographical expedition."}, {"Geography",}},{{"to Participate in geological expeditions."}, {"Geology",}},{{"Observe and care for patients, to help them to alleviate their condition."}, {"Medicine",}},{{"to Participate in physical competitions."}, {"Physical education and sport",}},{{"to Solve complex problems in chemistry, chemical participate in the Olympics."}, {"Chemistry",}},{{"to Understand technical drawings and diagrams, to draw or draw up the blueprints."}, {"Construction",}},{{"to Understand complex electronic circuits."}, {"Physics",}},{{"to Build something from wood with your own hands."}, {"woodworking",}},{{"Take an active part in the construction work."}, {"Construction",}},{{"to Engage in the historical circle, collect materials to make presentations on historical topics."}, {"History",}},{{"Work with literary sources, keep a diary of impressions on reading."}, {"Literature",}},{{"to Help in police work."}, {"Right, law",}},{{"Interested in the cost of the goods, to try to understand the pricing, wages, labor organization."}, {"Economics",}},{{"talking to friends in a foreign language."}, {"Foreign languages",}},{{"Visit the theatre."}, {"Stage art",}},{{"to Participate in theatrical competitions."}, {"Stage art",}},{{"to Take part in sports competitions."}, {"Physical education and sport",}},{{"Grow in the garden or in the garden plants, raise animals to care for them."}, {"Biology",}},{{"Working in a hospital, clinic or pharmacy."}, {"Medicine",}},{{"Working in the chemical industry."}, {"Chemistry",}},{{"to Participate in exhibitions of technical creativity."}, {"Engineering",}},{{"Work in the field of electricity or electronics."}, {"Physics",}},{{"Working at the bench, to manufacture various parts and products."}, {"Engineering",}},{{"to Perform drawings carpentry or model work."}, {"Construction",}},{{"Work in the construction crew."}, {"Construction",}},{{"Working engineer or military commander."}, {"Military law",}},{{"Hiking on historical places of his native land."}, {"History",}}};
    String[] professions = {"Biology", "Geography", "Geology", "Medicine", "Physics", "Chemistry", "Engineering", "metal", "woodworking", "Construction", "Military law", "History", "Literature", "Journalism", "Public activities", "Right, law", "the service Sector, manufacturing", "Mathematics", "Economics", "Foreign languages", "Visual arts", "Stage art", "Music", "Physical education and sport"};
    int[] profession_value = new int[24];
    String[][][] arr = {{{"Accountant"}, {"Mathematics 30","Economics 40",}},{{"Actor/ Actress"}, {"Stage art 45","Physical education and sport 30","Literature 20","Foreign languages 25",}},{{"Architect"}, {"Engineering 50","Mathematics 45","Physics 80",}},{{"Artist"}, {"Visual arts 10",}},{{"Baker"}, {}},{{"Ballet Dancer"}, {"Stage art 20","Physical education and sport 30",}},{{"Biologist"}, {"Biology 65","Mathematics 20",}},{{"Boxer"}, {"Physical education and sport 50",}},{{"Businessman"}, {"Economics 30","Mathematics 30",}},{{"Cameraman"}, {"Engineering 15","Foreign languages 20","Visual arts 10",}},{{"Carpenter"}, {"Mathematics 30","Physics 50","woodworking 20","Construction 40",}},{{"Cashier"}, {"Mathematics 40","Economics 20",}},{{"Computer Programmer"}, {"Mathematics 25","Physics 30",}},{{"Customs Officer"}, {"Right, law 15",}},{{"Delivery Man"}, {}},{{"Dentist"}, {"Medicine 40","Biology 35",}},{{"Doctor"}, {"Medicine 50","Biology 40",}},{{"Electrician"}, {"metal 25","Engineering 35","Physics 45",}},{{"Engineer"}, {"Engineering 50","Physics 50","Mathematics 30",}},{{"Entrepreneur"}, {"Economics 30","Journalism 25",}},{{"Farmer"}, {"Biology 10",}},{{"Fireman"}, {"Physical education and sport 30",}},{{"Fisherman"}, {}},{{"Flight Attendant"}, {}},{{"Florist"}, {"Biology 25",}},{{"Gardener"}, {"Biology 35",}},{{"Guitarist"}, {"Music 15",}},{{"Hairdresser"}, {}},{{"Judge"}, {"Right, law 25","Foreign languages 30",}},{{"Lawyer"}, {"Right, law 25","Foreign languages 30",}},{{"Librarian"}, {}},{{"Lifeguard"}, {"Physical education and sport 40",}},{{"Model"}, {"Physical education and sport 20","Stage art 25",}},{{"Musician"}, {"Music 20",}},{{"Nurse"}, {"Medicine 45","Biology 40",}},{{"Office Worker"}, {"Economics 30","Mathematics 25",}},{{"Optician"}, {"Biology 45","Medicine 35",}},{{"Paramedic"}, {"Biology 45","Medicine 35",}},{{"Pharmacist"}, {"Biology 45","Medicine 35",}},{{"Photographer"}, {"Visual arts 10",}},{{"Plumber"}, {}},{{"Police Officer"}, {"Right, law 15","Physical education and sport 35",}},{{"Politician"}, {"Right, law 20",}},{{"Priest"}, {}},{{"Real Estate Agent"}, {"Economics 40","Mathematics 30","Geography 20",}},{{"Receptionist"}, {"Mathematics 35","Foreign languages 25",}},{{"Repairman"}, {}},{{"Singer"}, {"Music 15",}},{{"Taxi Driver"}, {}},{{"Teacher"}, {}},{{"Violinist"}, {"Music 15",}},{{"Waiter"}, {}},};
    ArrayList<String> answer = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1_activity);

        question = findViewById(R.id.textView_question);
        counter = 0;
        counter2 = 0;

        question.setText(counter + ") " + test[0][0][0]);

        bt_no = findViewById(R.id.button_no);
        bt_no_no = findViewById(R.id.button_no_no);
        bt_ntral = findViewById(R.id.button_ntral);
        bt_plus = findViewById(R.id.button_yes);
        bt_plus_plus = findViewById(R.id.button_yes_yes);

        pieChart = findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);
        pieDataSet = new PieDataSet(pieEntryList,"");
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart.setDrawHoleEnabled(false);
        pieData = new PieData(pieDataSet);
        for (int i = 0; i < professions.length; i++) {
            pieEntryList.add(i, new PieEntry(0, ""));
        }
        pieChart.getLegend().setWordWrapEnabled(true);
    }

    public ArrayList calculate_professions() {
        for (int i = 0; i < arr.length; i++) {
            Boolean tf = false;
            for (int j = 0; j < arr[i][1].length; j++) {
                //Boolean tf = false;
                for (int m = 0; m < professions.length; m++) {
                    if (arr[i][1][j].contains(professions[m])) {
                        int c1 = professions[m].length();
                        int stolb = Integer.valueOf(arr[i][1][j].substring(c1 + 1, c1 + 3));
                        if (stolb > profession_value[m]) tf = true;
                    }
                }
                /*if (!tf) {
                    answer.add(arr[i][0][0]);
                    counter2++;
                }*/
            }
            if (!tf) {
                answer.add(arr[i][0][0]);
                counter2++;
            }
        }
        return answer;
    }


    public void plus_plus(View view) {
        piechartchange(10);
        if (counter < 111) {
            counter++;
            question.setText(counter + ") " + test[counter][0][0]);
        }
        else {
            question.setText("You have finished. Congrats!");
            clickenableshare();
        }

    }

    public void plus(View view) {
        piechartchange(5);
        if (counter < 111) {
            counter++;
            question.setText(counter + ") " + test[counter][0][0]);
        }
        else {
            question.setText("You have finished. Congrats!");
            clickenableshare();
        }
    }

    public void ntral(View view) {
        if (counter < 111) {
            counter++;
            question.setText(counter + ") " + test[counter][0][0]);
        }
        else {
            question.setText("You have finished. Congrats!");
            clickenableshare();
        }
    }

    public void no(View view) {
        piechartchange(-5);
        if (counter < 111) {
            counter++;
            question.setText(counter + ") " + test[counter][0][0]);
        }
        else {
            question.setText("You have finished. Congrats!");
            clickenableshare();
        }
    }

    public void no_no(View view) {
        piechartchange(-10);
        if (counter < 111) {
            counter++;
            question.setText(counter + ") " + test[counter][0][0]);
        }
        else {
            question.setText("You have finished. Congrats!");
            clickenableshare();
        }
    }

    public void piechartchange(int value) {
        int id = -1;
        for (int j = 0; j < test[counter][1].length; j++) {
            for (int v = 0; v < professions.length; v++) {
                if (test[counter][1][j] == professions[v]) {
                    id = v;
                    //pieDataSet.removeEntry(id);
                    profession_value[id] += value;
                    if (profession_value[id] <= 0) {
                        profession_value[id] = 0;
                    }
                    else {
                        pieDataSet.removeEntry(id);
                        int c = profession_value[id];
                        String b = professions[id];
                        pieEntryList.add(id, new PieEntry(c, b));
                        pieChart.setData(pieData);
                        pieChart.invalidate();
                    }
                }
            }
        }
    }

    public void clickenableshare() {
        bt_plus_plus.setClickable(false);
        bt_plus_plus.setEnabled(false);

        bt_plus.setClickable(false);
        bt_plus.setEnabled(false);

        bt_ntral.setClickable(false);
        bt_ntral.setEnabled(false);

        bt_no.setClickable(false);
        bt_no.setEnabled(false);

        bt_no_no.setClickable(false);
        bt_no_no.setEnabled(false);

        ArrayList anw2 = calculate_professions();

        for (int i = 0; i < counter2; i++) {
            Log.d("mLog", anw2.get(i).toString());
        }

        String answer123 = "";
        SharedPreferences sp = getSharedPreferences("PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt("amount", counter2);
        ed.apply();
        for (int j = 0; j < counter2; j++) {
            String s = answer.get(j);
            ed.putString("profession" + j,  answer.get(j));
            answer123 = answer123 + " " + answer.get(j);
        }
        ed.putString("absolute", answer123);
        ed.apply();
        ed.putInt("test_is_done", 1);
        ed.apply();
        //Log.d("mLog", sp.getString("absolute", "dfsdgfhjkhjgfdsgthyyujyhygf"));
        /*for (int j = 0; j < counter2; j++) {
            Log.d("mLog", sp.getString("profession" + j, "joe"));
        }*/
    }
}
