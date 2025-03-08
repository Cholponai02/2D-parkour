import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Вход в аккаунт");

        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        myLogin(panel,frame);

        frame.setVisible(true);
    }
    private static void myLogin(JPanel panel, JFrame window){
        panel.setLayout(null);


        //Метка Логин
        JLabel userLabel = new JLabel("Логин: ");
        userLabel.setBounds(60,20,165,25);
        panel.add(userLabel);
        // Поле для ввода логина
        JTextField userText = new JTextField(20);
        userText.setBounds(120,20,120,25);
        panel.add(userText);
        // Метка пароля
        JLabel userPass = new JLabel("Пароль: ");
        userPass.setBounds(45,70,80,25);
        panel.add(userPass);
        // Поле для ввода пароля
        JPasswordField passText = new JPasswordField(20);
        passText.setBounds(100,70,160,25);
        panel.add(passText);
        //Кнопка
        JButton btn = new JButton("Войти");
        btn.setBounds(100,120,150,30);
        panel.add(btn);

        btn.addActionListener( e ->{
            String userName = userText.getText();
            String password = new String(passText.getPassword());
            if(userName.equals("admin") && password.equals("1234")){
                JOptionPane.showMessageDialog(null,"Вход успешен");
                window.dispose();
                myAccount(userName);
            }
            else{
                JOptionPane.showMessageDialog(null,"Неверный пароль или логин");
            }
        });

    }

    private static void myAccount(String userName){
        JFrame frame = new JFrame("Аккаунт: " + userName);
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Добро пожаловать, " + userName);
        userLabel.setBounds(30,20,200,25);
        frame.add(userLabel);

        JButton btn = new JButton("Смена тема");
        btn.setBounds(200,20,150,30);
        frame.add(btn);


        //------------- Форма для заполнения ----------
        JLabel userFullName = new JLabel("Введите ФИО: ");
        userFullName.setBounds(30,55,200,30);
        frame.add(userFullName);

        JTextField fullNameField = new JTextField();
        fullNameField.setBounds(180,55,150,27);
        frame.add(fullNameField);

        JLabel birthDateLabel = new JLabel("Введите дату рождения: ");
        birthDateLabel.setBounds(30,90,200,30);
        frame.add(birthDateLabel);

        SpinnerDateModel dateModel = new SpinnerDateModel();
        JSpinner birthDateSpinner = new JSpinner(dateModel);
        birthDateSpinner.setBounds(180,90,150,27);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(birthDateSpinner,"dd.MM.yyyy");
        birthDateSpinner.setEditor(editor);
        frame.add(birthDateSpinner);
//        JTextField birthDateField = new JTextField();
//        birthDateField.setBounds(180,90,150,27);
//        frame.add(birthDateField);

        JLabel ageLabel = new JLabel("Введите текущий возраст: ");
        ageLabel.setBounds(25,125,200,30);
        frame.add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(180,125,150,27);
        frame.add(ageField);

        JLabel phoneLabel = new JLabel("Введите номер телефона: ");
        phoneLabel.setBounds(20,160,200,30);
        frame.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(180,160,150,27);
        frame.add(phoneField);

        JLabel genderLabel = new JLabel("Выберите пол: ");
        genderLabel.setBounds(30,195,200,30);
        frame.add(genderLabel);
        String[] genderOptions = {"Мужской", "Женский"};
        JComboBox<String> genderComboBox = new JComboBox<>(genderOptions);
        genderComboBox.setBounds(180,195,200,30);
        frame.add(genderComboBox);

        JLabel hobbyLabel = new JLabel("Выберите увлечение: ");
        hobbyLabel.setBounds(30,230,200,30);
        frame.add(hobbyLabel);
        String[] hobbyOptions = {"Программирование", "Футбол", "Танцы" , "Шахматы", "Баскетбол", "Чтение"};
        JComboBox<String> hobbyComboBox = new JComboBox<>(hobbyOptions);
        hobbyComboBox.setBounds(180,230,200,30);
        frame.add(hobbyComboBox);

        JLabel hh = new JLabel("Кем работаете: ");
        hh.setBounds(30,265, 150,30);
        frame.add(hh);
        JTextField hhField = new JTextField();
        hhField.setBounds(180,265,200,27);
        frame.add(hhField);

        JButton saveButton = new JButton("Сохранить");
        saveButton.setBounds(100,335,150,30);
        frame.add(saveButton);

        final boolean[] isSaved = {false};

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(30, 370, 350, 30);
        frame.add(resultLabel);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message;
                if(isSaved[0] == false)
                {
                    System.out.println("Данные сохранение");
                    System.out.println("ФИО: " + fullNameField.getText());
                    // System.out.println("Дата рождения: ");
                    Date selectedDate = (Date) birthDateSpinner.getValue();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                    String birthDate = dateFormat.format(selectedDate);
                    System.out.println("Дата рождения: " + birthDate);
                    LocalDate myDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int myAge = Period.between(myDate,LocalDate.now()).getYears();
                    System.out.println("Возраст из системы: " + myAge);
                    int myMonth = myDate.getMonthValue();
                    System.out.println("Месяц из системы: " + myMonth);

                    if (myAge > 0 && myAge <= 6) {
                        message = "Еще маленький для компьютера";
                        System.out.println("Еще маленький для компьютера");
                        resultLabel.setForeground(Color.ORANGE);
                    } else if (myAge >= 7 && myAge <= 12) {
                        message = "Ребенок";
                        System.out.println("Ребенок");
                        resultLabel.setForeground(Color.BLUE);
                    } else if (myAge >= 13 && myAge <= 16) {
                        message = "Подросток";
                        System.out.println("Подросток");
                        resultLabel.setForeground(Color.GREEN);
                    } else if (myAge >= 17 && myAge <= 18) {
                        message = "Совершеннолетний";
                        System.out.println("Совершеннолетний");
                        resultLabel.setForeground(Color.MAGENTA);
                    } else if (myAge >= 19 && myAge <= 60) {
                        System.out.println("Взрослый");
                        resultLabel.setForeground(Color.BLACK);
                        message = "Взрослый";
                    } else if (myAge >= 61) {
                        message = "Пенсионер";
                        System.out.println("Пенсионер");
                        resultLabel.setForeground(Color.GRAY);
                    } else {
                        message = "Некорректный возраста";
                        System.out.println("Некорректный возраст");
                    }
                    resultLabel.setText("Возраст: " + myAge + " лет - " + message);
                    // от 0 до 6 еще маленький для компа  &&
                    // от 7 до 12 ребенок
                    // от 13 до 16 подросток
                    // от 17 до 18 совершеннолетний
                    // больше 19  до 60 взрослый
                    // больше 61 и дальше пенсионер

                    System.out.println("Возраст: ");
                    System.out.println("Номер телефона: ");
                    System.out.println("Пол: " + genderComboBox.getSelectedItem());
                    System.out.println("Увлечение: ");
                    System.out.println("Работа: " + hhField.getText());
                    JOptionPane.showMessageDialog(frame,"Данные сохранены ✅","Успех",JOptionPane.INFORMATION_MESSAGE);
                    saveButton.setText("Изменить");
                    isSaved[0] = true;

                    String filename = fullNameField.getText().replace(" ", "_") + ".txt"; // Убираем пробелы
                    String userData = "ФИО: " + fullNameField.getText() + "\n" +
                            "Дата рождения: " + birthDate + "\n" +
                            "Возраст: " + ageField.getText() + "\n" +
                            "Телефон: " + phoneField.getText() + "\n" +
                            "Пол: " + genderComboBox.getSelectedItem() + "\n" +
                            "Увлечение: " + hobbyComboBox.getSelectedItem();

//                    saveToFile("user_data.txt", userData);
                    saveToFile(filename, userData);
                }
                else{
                    JOptionPane.showMessageDialog(frame,"Данные изменены ✅✅✅","Успех",JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });



        //---конец формы-----
        frame.setVisible(true);
    }

    private static void saveToFile(String filename, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, false))) {
            writer.write(data);
            writer.newLine();
            writer.flush(); // close
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}