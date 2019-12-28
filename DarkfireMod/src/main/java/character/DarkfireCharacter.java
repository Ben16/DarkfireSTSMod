package character;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.esotericsoftware.spine.AnimationState;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;


import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.helpers.Prefs;
import com.megacrit.cardcrawl.helpers.SaveHelper;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.screens.CharSelectInfo;
import com.megacrit.cardcrawl.screens.stats.CharStat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

import cards.AshSpray;
import cards.Blaze;
import cards.Defend;
import cards.EmberShell;
import cards.Strike;
import cards.WheelingFlame;
import cards.filler.FillerAC;
import cards.filler.FillerAU;
import cards.filler.FillerPC;
import cards.filler.FillerPR;
import cards.filler.FillerSR;
import cards.filler.FillerSU;

public class DarkfireCharacter extends AbstractPlayer {
  public static final Logger logger = LogManager.getLogger(DarkfireCharacter.class.getName());

  public static final String NAME = "The Darkfire";
  public static final String DESCRIPTION = "A warrior who burns with unending flame.";
  public static final int MAX_HP = 70;
  public static final int MAX_ORBS = 0;
  public static final int GOLD = 100;
  public static final int CARD_DRAW = 5;
  public static final Color COLOR = new Color(0, 0, (float)0.54, 1);
  public static final int ASCENSION_HP_LOSS = 4;
  private CharStat charStat;
  private Prefs prefs; //prefs stuff all stolen from ironclad - dont know  how prefs work yet

  //TODO: make these not all null
  public DarkfireCharacter(String name) {
    super(name, DarkfireEnum.DARKFIRE);

    // stolen from ironclad, for now
    this.charStat = new CharStat(this);

    this.dialogX = this.drawX + 0.0F * Settings.scale;
    this.dialogY = this.drawY + 220.0F * Settings.scale;

    initializeClass(null, "images/characters/ironclad/shoulder2.png", "images/characters/ironclad/shoulder.png", "images/characters/ironclad/corpse.png",
            getLoadout(), -4.0F, -16.0F, 220.0F, 290.0F, new EnergyManager(3));

    loadAnimation("images/characters/ironclad/idle/skeleton.atlas", "images/characters/ironclad/idle/skeleton.json", 1.0F);
    AnimationState.TrackEntry e = this.state.setAnimation(0, "Idle", true);
    this.stateData.setMix("Hit", "Idle", 0.1F);
    e.setTimeScale(0.6F);
    // end steal
  }

  @Override
  public ArrayList<String> getStartingDeck() {
    ArrayList<String> retVal = new ArrayList<String>(); // empty deck
    // TODO: add an actual starting hand
    retVal.add("darkfire:Strike");
    retVal.add("darkfire:Strike");
    retVal.add("darkfire:Strike");
    retVal.add("darkfire:Strike");
    retVal.add("darkfire:Strike");
    retVal.add("darkfire:Defend");
    retVal.add("darkfire:Defend");
    retVal.add("darkfire:Defend");
    retVal.add("darkfire:Defend");
    retVal.add("darkfire:Defend");
    return retVal;
  }

  @Override
  public ArrayList<String> getStartingRelics() {
    return new ArrayList<String>();
  }

  @Override
  public CharSelectInfo getLoadout() {
    return new CharSelectInfo(NAME, DESCRIPTION, MAX_HP, MAX_HP, MAX_ORBS, GOLD, CARD_DRAW, this, getStartingRelics(), getStartingDeck(), false);
  }

  @Override
  public String getTitle(PlayerClass playerClass) {
    return NAME;
  }

  @Override
  public AbstractCard.CardColor getCardColor() {
    return AbstractCardEnum.DARKFIRE_COLOR;
  }

  @Override
  public Color getCardRenderColor() {
    return COLOR;
  }

  @Override
  public String getAchievementKey() {
    return "RUBY"; // just using ironclad's
  }

  @Override
  public ArrayList<AbstractCard> getCardPool(ArrayList<AbstractCard> arrayList) {
    // make util method to get all darkfire cards
    arrayList.add(new Strike());
    arrayList.add(new Defend());
    arrayList.add(new AshSpray());
    arrayList.add(new Blaze());
    arrayList.add(new EmberShell());
    arrayList.add(new WheelingFlame());

    // these are all filler, just to get the game to not freeze
    arrayList.add(new FillerAC());
    arrayList.add(new FillerAU());
    arrayList.add(new FillerPC());
    arrayList.add(new FillerPR());
    arrayList.add(new FillerSR());
    arrayList.add(new FillerSU());
    return arrayList;
  }

  @Override
  public AbstractCard getStartCardForEvent() {
    // TODO: make this an actual card
    return null;
  }

  @Override
  public Color getCardTrailColor() {
    return COLOR;
  }

  @Override
  public String getLeaderboardCharacterName() {
    return "IRONCLAD"; // it's not mine - it's ironclad's!
  }

  @Override
  public Texture getEnergyImage() {
    return ImageMaster.RED_ORB_FLASH_VFX; // stolen from ol' iron himself
  }

  @Override
  public int getAscensionMaxHPLoss() {
    return ASCENSION_HP_LOSS;
  }

  @Override
  public BitmapFont getEnergyNumFont() {
    // stolen from Ironclad
    return FontHelper.energyNumFontRed;
  }

  @Override
  public void renderOrb(SpriteBatch spriteBatch, boolean b, float v, float v1) {

  }

  @Override
  public void updateOrb(int i) {

  }

  // prefs stuff stolen from ironclad
  @Override
  public Prefs getPrefs() {
    if (this.prefs == null) {
      logger.error("prefs need to be initialized first!");
    }
    return this.prefs;
  }

  @Override
  public void loadPrefs() {
    this.prefs = SaveHelper.getPrefs("STSDataVagabond");
  }

  @Override
  public CharStat getCharStat() {
    return this.charStat;
  }

  @Override
  public int getUnlockedCardCount() {
    return 0;
  }

  @Override
  public int getSeenCardCount() {
    return 0;
  }

  @Override
  public int getCardCount() {
    return 0;
  }

  @Override
  public boolean saveFileExists() {
    return false;
  }

  @Override
  public String getWinStreakKey() {
    return null;
  }

  @Override
  public String getLeaderboardWinStreakKey() {
    return null;
  }

  @Override
  public void renderStatScreen(SpriteBatch spriteBatch, float v, float v1) {

  }

  @Override
  public void doCharSelectScreenSelectEffect() {

  }

  @Override
  public String getCustomModeCharacterButtonSoundKey() {
    return "ATTACK_HEAVY";
  }

  @Override
  public Texture getCustomModeCharacterButtonImage() {
    return ImageMaster.FILTER_IRONCLAD;
  }

  @Override
  public CharacterStrings getCharacterString() {
    return CardCrawlGame.languagePack.getCharacterString("Ironclad");
  }

  @Override
  public String getLocalizedCharacterName() {
    return NAME;
  }

  @Override
  public void refreshCharStat() {
    this.charStat = new CharStat(this);
  }

  @Override
  public AbstractPlayer newInstance() {
    // TODO: return instance of this character
    return new DarkfireCharacter(NAME);
  }

  @Override
  public TextureAtlas.AtlasRegion getOrb() {
    return null;
  }

  @Override
  public String getSpireHeartText() {
    return "hearty heart heart";
  }

  @Override
  public Color getSlashAttackColor() {
    return COLOR;
  }

  @Override
  public AbstractGameAction.AttackEffect[] getSpireHeartSlashEffect() {
    return new AbstractGameAction.AttackEffect[0];
  }

  @Override
  public String getVampireText() {
    return "vampire ooh spooky";
  }
}
