package controllers;

import models.Words;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GameController extends Controller
{
    private FormFactory formFactory;

    @Inject
    public GameController(FormFactory formFactory)
    {
        this.formFactory = formFactory;
    }

    public Result getCreateStory()
    {
        return ok(views.html.createstory.render());
    }

    public Result postCreateStory()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String place = form.get("place");
        String adjective = form.get("adjective");
        String noun1 = form.get("noun1");
        String noun2 = form.get("noun2");

        Words words = new Words();
        words.setPlace1(place);
        words.setAdjective1(adjective);
        words.setNoun1(noun1);
        words.setNoun2(noun2);

        return ok(views.html.story.render(words))   ;
    }

    private List<String> usedPlace1 = new ArrayList<>();
    private List<String> usedAdjective1 = new ArrayList<>();
    private List<String> usedNoun1= new ArrayList<>();
    private List<String> usedNoun2 = new ArrayList<>();
    private List<String> usedVerbPastTense1 = new ArrayList<>();

    public Result getStart()
    {
        return ok(views.html.start.render());
    }

    public Result getFirstStory()
    {
        Words words = new Words();
        words.setPlace1("Parking Lot");
        words.setAdjective1("fuzzy");
        words.setNoun1("ball");
        words.setNoun2("bat");
        words.setVerbPastTense1("played");

        return ok(views.html.story.render(words));
    }

    public Result getSecondStory()
    {
        Words words = new Words();
        words.setPlace1("Hospital");
        words.setAdjective1("blue");
        words.setNoun1("chord");
        words.setNoun2("falcon");
        words.setVerbPastTense1("lectured");

        return ok(views.html.story.render(words));
    }

    public Result getThirdStory()
    {
        Words words = new Words();
        words.setPlace1("Dumpster");
        words.setAdjective1("warm");
        words.setNoun1("computer");
        words.setNoun2("video game");
        words.setVerbPastTense1("crashed");

        return ok(views.html.story.render(words));
    }

    public Result getRandomStory()
    {
        Words words = new Words();
        Random random  = new Random();
        List<String> place1 = new ArrayList<>();

            Iterator<String> place1Iter = usedPlace1.iterator();

            place1.add("McDonalds");
            place1.add("Airport");
            place1.add("Police Station");
            int place1InitialSize = place1.size();

            while(place1Iter.hasNext())
            {
                String string = place1Iter.next();
                if(place1.contains(string))
                {
                    place1.remove(string);
                }
            }

            int index = random.nextInt(place1.size());

            if(place1.get(index).equals("McDonalds"))
                words.setPlace1Image("mcdonalds.jpg");
            if(place1.get(index).equals("Airport"))
                words.setPlace1Image("airport.jpg");
            if(place1.get(index).equals("Police Station"))
                words.setPlace1Image("policeStation.jpg");

            words.setPlace1(place1.get(index));
            usedPlace1.add(place1.get(index));

            if(usedPlace1.size() == place1InitialSize)
            {
                usedPlace1.clear();
            }

        List<String> adjective1 = new ArrayList<>();

            Iterator<String> adjective1Iter = usedAdjective1.iterator();

            adjective1.add("amazing");
            adjective1.add("simple");
            adjective1.add("ridiculous");
            int adjective1InitialSize = adjective1.size();

            while(adjective1Iter.hasNext())
            {
                String string = adjective1Iter.next();
                if(adjective1.contains(string))
                {
                    adjective1.remove(string);
                }
            }

            index = random.nextInt(adjective1.size());

            if(adjective1.get(index).equals("amazing"))
                words.setAdjective1Image("amazing.png");
            if(adjective1.get(index).equals("simple"))
                words.setAdjective1Image("simple.jpg");
            if(adjective1.get(index).equals("ridiculous"))
                words.setAdjective1Image("ridiculous.jpg");

            words.setAdjective1(adjective1.get(index));
            usedAdjective1.add(adjective1.get(index));

            if(usedAdjective1.size() == adjective1InitialSize)
                {
                    usedAdjective1.clear();
                }

        List<String> noun1 = new ArrayList<>();

            Iterator<String> noun1Iter = usedNoun1.iterator();

            noun1.add("dog");
            noun1.add("apple");
            noun1.add("airplane");

            int noun1InitialSize = noun1.size();

            while(noun1Iter.hasNext())
            {
                String string = noun1Iter.next();
                if(noun1.contains(string))
                {
                    noun1.remove(string);
                }
            }

            index = random.nextInt(noun1.size());

            if(noun1.get(index).equals("dog"))
                words.setNoun1Image("dog.jpg");
            if(noun1.get(index).equals("apple"))
                words.setNoun1Image("apple.jpg");
            if(noun1.get(index).equals("airplane"))
                words.setNoun1Image("airplane.jpg");

            words.setNoun1(noun1.get(index));
            usedNoun1.add(noun1.get(index));

            if(usedNoun1.size() == noun1InitialSize)
            {
                usedNoun1.clear();
            }

        List<String> noun2 = new ArrayList<>();

            Iterator<String> noun2Iter = usedNoun2.iterator();

            noun2.add("mug");
            noun2.add("machine gun");
            noun2.add("helicopter");

            int noun2InitialSize = noun2.size();

            while(noun2Iter.hasNext())
            {
                String string = noun2Iter.next();
                if(noun2.contains(string))
                {
                    noun2.remove(string);
                }
            }

            index = random.nextInt(noun2.size());

            if(noun2.get(index).equals("mug"))
                words.setNoun2Image("mug.jpg");
            if(noun2.get(index).equals("machine gun"))
                words.setNoun2Image("machineGun.jpg");
            if(noun2.get(index).equals("helicopter"))
                words.setNoun2Image("helicopter.jpg");

            words.setNoun2(noun2.get(index));
            usedNoun2.add(noun2.get(index));

            if(usedNoun2.size() == noun2InitialSize)
            {
                usedNoun2.clear();
            }

        List<String> verbPastTense1 = new ArrayList<>();

            Iterator<String> verbPastTense1Iter = usedVerbPastTense1.iterator();

            verbPastTense1.add("attacked");
            verbPastTense1.add("expunged");
            verbPastTense1.add("deleted");

            int verbPastTense1InitialSize = verbPastTense1.size();

            while(verbPastTense1Iter.hasNext())
            {
                String string = verbPastTense1Iter.next();
                if(verbPastTense1.contains(string))
                {
                    verbPastTense1.remove(string);
                }
            }

            index = random.nextInt(verbPastTense1.size());

            if(verbPastTense1.get(index).equals("attacked"))
                words.setVerbPastTense1Image("attacked.jpg");
            if(verbPastTense1.get(index).equals("expunged"))
                words.setVerbPastTense1Image("expunged.jpg");
            if(verbPastTense1.get(index).equals("deleted"))
                words.setVerbPastTense1Image("deleted.jpg");

            words.setVerbPastTense1(verbPastTense1.get(index));
            usedVerbPastTense1.add(verbPastTense1.get(index));

            if(usedVerbPastTense1.size() == verbPastTense1InitialSize)
            {
                usedVerbPastTense1.clear();
            }

        return ok(views.html.story.render(words));
    }
}