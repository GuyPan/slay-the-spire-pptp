package pptpinsts.cards.common;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import pptpinsts.cards.BaseCard;
import pptpinsts.character.Poppuko;
import pptpinsts.util.CardStats;

public class PptpAllSeeingEye extends BaseCard {
    public static final String ID = makeID(PptpAllSeeingEye.class.getSimpleName());
    private static final CardStats info = new CardStats(
            Poppuko.Meta.CARD_COLOR, //The card color. If you're making your own character, it'll look something like this. Otherwise, it'll be CardColor.RED or something similar for a basegame character color.
            CardType.ATTACK, //The type. ATTACK/SKILL/POWER/CURSE/STATUS
            CardRarity.COMMON, //Rarity. BASIC is for starting cards, then there's COMMON/UNCOMMON/RARE, and then SPECIAL and CURSE. SPECIAL is for cards you only get from events. Curse is for curses, except for special curses like Curse of the Bell and Necronomicurse.
            CardTarget.ENEMY, //The target. Single target is ENEMY, all enemies is ALL_ENEMY. Look at cards similar to what you want to see what to use.
            3 //The card's base cost. -1 is X cost, -2 is no cost for unplayable cards like curses, or Reflex.
    );
    private static final int DAMAGE = 996; //Default
    private static final int UPG_DAMAGE = 3; //Default
    private static final int BLOCK = 996; //Default
    private static final int UPG_BLOCK = 3; //Default
    private static final int MAGIC = 5; //Default
    private static final int UPG_MAGIC = 2; //Default
    private static final int UPG_COST = 1; //Default

    public PptpAllSeeingEye() {
        super(ID, info); //Pass the required information to the BaseCard constructor.
        setDamage(DAMAGE);
        setBlock(BLOCK);
        setMagic(MAGIC, UPG_MAGIC); //Sets the card's damage and how much it changes when upgraded.
        setCostUpgrade(UPG_COST);
        setEthereal(true);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        //addToBot(new DamageAction(m, new DamageInfo(p, damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
        //addToBot(new ScryAction(magicNumber));
        //addToBot(new ChannelAction(new Dark()));
        //AbstractDungeon.getCurrRoom().addCardToRewards();
        addToBot(new ApplyPowerAction(m, p, new PoisonPower(m, p, this.magicNumber), this.magicNumber, AbstractGameAction.AttackEffect.POISON));

    }


    @Override
    public AbstractCard makeCopy() { //Optional
        return new PptpAllSeeingEye();
    }
}
