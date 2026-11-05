package iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import adapter.InvertedIterator;
import domain.Symptom;

public class Covid19PacientInvertedIterator implements InvertedIterator {

    private List<Symptom> symptoms = new ArrayList<>();
    private int position;

    public Covid19PacientInvertedIterator(Set<Symptom> s) {
        symptoms.addAll(s);
    }

    @Override
    public void goLast() {
        position = symptoms.size() - 1;
    }

    @Override
    public boolean hasPrevious() {
        return position >= 0;
    }

    @Override
    public Object previous() {
        return symptoms.get(position--);
    }
}