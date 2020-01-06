package util;

import com.megacrit.cardcrawl.cards.AbstractCard;

import java.util.ArrayList;

import cards.AshSpray;
import cards.Blaze;
import cards.BurningShot;
import cards.Defend;
import cards.EmberShell;
import cards.Strike;
import cards.WheelingFlame;
import cards.filler.FillerAU;
import cards.filler.FillerPC;
import cards.filler.FillerPR;
import cards.filler.FillerSR;
import cards.filler.FillerSU;

public class DarkfireCardList {
  public static ArrayList<AbstractCard> GetAllCards() {
    ArrayList<AbstractCard> retVal = new ArrayList<AbstractCard>();
    // make util method to get all darkfire cards
    retVal.add(new Strike());
    retVal.add(new Defend());
    retVal.add(new AshSpray());
    retVal.add(new Blaze());
    retVal.add(new EmberShell());
    retVal.add(new WheelingFlame());
    retVal.add(new BurningShot());

    // these are all filler, just to get the game to not freeze
    retVal.add(new FillerAU());
    retVal.add(new FillerPC());
    retVal.add(new FillerPR());
    retVal.add(new FillerSR());
    retVal.add(new FillerSU());
    return retVal;
  }
}
