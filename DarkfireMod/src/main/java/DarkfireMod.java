package DarkfireMod;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.EditCharactersSubscriber;

@SpireInitializer
public class DarkfireMod implements EditCardsSubscriber, EditCharactersSubscriber {
  public DarkfireMod() {
    BaseMod.subscribe(this);
  }

  public static void initialize() {
    new DarkfireMod();
  }

  @Override
  public void receiveEditCards() {
    //TODO
  }

  @Override
  public void receiveEditCharacters() {
    //TODO
  }
}
