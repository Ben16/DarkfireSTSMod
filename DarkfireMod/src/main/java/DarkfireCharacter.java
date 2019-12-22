import com.evacipated.cardcrawl.modthespire.lib.SpireEnum;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.CardLibrary;


public class DarkfireCharacter {
  @SpireEnum
  public static AbstractPlayer.PlayerClass DARKFIRE;

  @SpireEnum(name = "DARK_BLUE")
  public static AbstractCard.CardColor COLOR_DARK_BLUE;

  @SpireEnum(name = "DARK_BLUE")
  public static CardLibrary.LibraryType LIBRARY_DARK_BLUE;
}
