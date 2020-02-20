package util;

import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;

import cards.AshSpray;
import cards.Blaze;
import cards.BlindingFlame;
import cards.BurningForm;
import cards.BurningShot;
import cards.Defend;
import cards.EmberShell;
import cards.FlareStorm;
import cards.Strike;
import cards.WheelingFlame;
import cards.filler.FillerPC;
import cards.filler.FillerSR;
import cards.flames.BlueFlame;
import cards.flames.GreenFlame;
import cards.flames.PurpleFlame;
import cards.flames.RedFlame;
import cards.flames.YellowFlame;

public class DarkfireCardList {
  public static ArrayList<AbstractCard> GetAllCards() {
    ArrayList<AbstractCard> retVal = new ArrayList<AbstractCard>();
    retVal.add(new Strike());
    retVal.add(new Defend());
    retVal.add(new AshSpray());
    retVal.add(new Blaze());
    retVal.add(new EmberShell());
    retVal.add(new WheelingFlame());
    retVal.add(new BurningShot());
    retVal.add(new BlindingFlame());
    retVal.add(new BurningForm());
    retVal.add(new FlareStorm());

    // these are all filler, just to get the game to not freeze
    retVal.add(new FillerPC());
    retVal.add(new FillerSR());
    return retVal;
  }

  public static ArrayList<AbstractCard> GetAllFlameCards() {
    ArrayList<AbstractCard> retVal = new ArrayList<AbstractCard>();
    retVal.add(new PurpleFlame());
    retVal.add(new BlueFlame());
    retVal.add(new YellowFlame());
    retVal.add(new RedFlame());
    retVal.add(new GreenFlame());
    return retVal;
  }
}
