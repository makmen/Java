import tasks.one.FactoryShapes;
import tasks.one.Shape;
import tasks.three.People;
import tasks.three.Person;
import tasks.two.CalcClosePoints;
import tasks.two.Point;
import writer.WriteDataBinary;
import writer.WriteDataText;
import writer.WriterDataBinaryBuffered;
import writer.WriterDataTextBuffered;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AMakas on 20.01.2017.
 */
public class Launcher {
    static public void main(String[] args) {
        WriteDataBinary wb = new WriteDataBinary();
        WriterDataBinaryBuffered wbb = new WriterDataBinaryBuffered();
        WriteDataText wt = new WriteDataText();
        WriterDataTextBuffered wtb = new WriterDataTextBuffered();

        /*
        1 Сгенерировать множество различных геометрических фигур, для каждой из которых известен метод вычисления
        площади. Для каждой фигуры вычислить площадь, данные записать в файл.
         */
        ArrayList<Shape> listShapes = new ArrayList<>();
        FactoryShapes factory = new FactoryShapes();
        for (int i = 0, count = 1000; i < count; i++) {
            listShapes.add(factory.factoryMethod((int)(Math.random()*5)));
        }
        wb.writeObject(listShapes, false);
        /*
        2 Сгенерировать набор случайно расположенных точек случайного цвета.
        Записать все в файл. Найти самые удалённые от центра точки записать их в файл.
        */
        ArrayList<Point> listPoints = new ArrayList<>();
        // генерим точки
        for (int i = 0, count = 1000; i < count; i++) {
            listPoints.add(new Point());
        }
        wbb.setFileName("points.txt");
        wbb.writeObject(listPoints, false);

        Point center = new Point(5, 10);
        wbb.writeString("Центр: " + center.toString());
        CalcClosePoints close = new CalcClosePoints(center, listPoints);
        close.calcAllDelta();
        close.getClosePoints();
        wbb.writeObject(close.getListClosePoints(), true);

        /*
        3 Файл содержит имена и фамилии. Отсортировать список людей по фамилии,
        записать в другой файл.
        Отсортировать по имени, записать в третий файл.
        */
        wtb.setFileName("people.txt");
        ArrayList<String> peopleReader = wtb.readString();
        People people = new People(peopleReader);

        people.sortByName();
        wtb.setFileName("peoplesortByName.txt");
        wtb.writeObject(people.getListPeople(), false);

        people.sortBySurname();
        wtb.setFileName("peoplesortBySurname.txt");
        wtb.writeObject(people.getListPeople(), false);

        /*
        4 Написать приложение принимающий на вход путь к файлу, содержащий xhtml разметку
        с помощью регулярок приложение осуществляет очистку от тегов и сохраняет результат в другой файл.
        */
        wtb.setFileName("Cars.xml");
        ArrayList<String> xhtml = wtb.readString();
        ArrayList<String> xhtmlDone = new ArrayList<>();
        for (int i = 0, count = xhtml.size(); i < count; i++) {
            Pattern pattern = Pattern.compile(">([^<]*?)</");
            Matcher matcher = pattern.matcher(xhtml.get(i));
            while(matcher.find()) {
                xhtmlDone.add(matcher.group(1));
            }
        }
        wtb.setFileName("CarsDone.txt");
        wtb.writeObject(xhtmlDone, false);
    }
}
