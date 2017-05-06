package by.kniga;

import by.quest.IQuest;
import by.quest.RescueQuestDama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by AMakas on 21.02.2017.
 */
@Component
public class Knight implements IKnight {

    private IQuest quest;

    @Autowired
    public Knight(IQuest quest) {
        this.quest = quest;
    }

    public void doQuest() {
        quest.someMethod();
    }

    @Autowired
    public void setQuest(IQuest quest) {
        this.quest = quest;
    }

}
