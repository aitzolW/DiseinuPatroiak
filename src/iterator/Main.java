package iterator;

import java.util.Iterator;

import adapter.Sorting;
import domain.Covid19Pacient;
import domain.Symptom;
import factory.SymptomFactory;

public class Main {

    public static void main(String[] args) {

        Covid19Pacient p =
                new Covid19Pacient(
                        "Ane",
                        29,
                        new SymptomFactory());

        p.addSymptom(new Symptom("s3", 10, 1), 1);
        p.addSymptom(new Symptom("s1", 10, 3), 2);
        p.addSymptom(new Symptom("s5", 10, 2), 3);
        p.addSymptom(new Symptom("s4", 10, 5), 4);
        p.addSymptom(new Symptom("s2", 10, 4), 5);

        System.out.println("Ordered by name");

        Iterator<Object> it1 =
                Sorting.sortedIterator(
                        new Covid19PacientInvertedIterator(
                                p.getSymptoms()),
                        new SymptomNameComparator());

        while (it1.hasNext()) {
            System.out.println(it1.next());
        }

        System.out.println();

        System.out.println("Ordered by severity");

        Iterator<Object> it2 =
                Sorting.sortedIterator(
                        new Covid19PacientInvertedIterator(
                                p.getSymptoms()),
                        new SeverityIndexComparator());

        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    }
}