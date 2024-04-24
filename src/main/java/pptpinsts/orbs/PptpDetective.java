package pptpinsts.orbs;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import pptpinsts.util.TextureLoader;
import com.megacrit.cardcrawl.localization.OrbStrings;

import static pptpinsts.BasicMod.*;

public class PptpDetective extends AbstractOrb {
    public static final String ORB_ID = makeID("PptpDetective");
    private static final OrbStrings orbString;
    public static final String[] DESC;

    public PptpDetective() {
        OrbStrings strings = CardCrawlGame.languagePack.getOrbString(ORB_ID);
        this.img = TextureLoader.getTexture("pptpinsts/images/orbs/PptpDetective.png");
        this.name = strings.NAME;
        this.description = strings.DESCRIPTION[0];
        this.baseEvokeAmount = 2;
        this.evokeAmount = this.baseEvokeAmount;
        this.basePassiveAmount = 1;
        this.passiveAmount = this.basePassiveAmount;
        this.updateDescription();
    }

    public void updateDescription() {
        this.applyFocus();
        this.description = DESC[0] + this.evokeAmount + DESC[1];
    }

    public void onEvoke() {
        AbstractDungeon.actionManager.addToTop(new GainEnergyAction(this.evokeAmount));
    }

    public void onStartOfTurn() {
//        AbstractDungeon.actionManager.addToBottom(new VFXAction(new OrbFlareEffect(this, OrbFlareColor.PLASMA), 0.1F));
        AbstractDungeon.actionManager.addToBottom(new GainEnergyAction(this.passiveAmount));
    }

//    public void triggerEvokeAnimation() {
//        CardCrawlGame.sound.play("ORB_PLASMA_EVOKE", 0.1F);
//        AbstractDungeon.effectsQueue.add(new PlasmaOrbActivateEffect(this.cX, this.cY));
//    }

    public void updateAnimation() {
        super.updateAnimation();
//        this.angle += Gdx.graphics.getDeltaTime() * 45.0F;
//        this.vfxTimer -= Gdx.graphics.getDeltaTime();
//        if (this.vfxTimer < 0.0F) {
//            AbstractDungeon.effectList.add(new PlasmaOrbPassiveEffect(this.cX, this.cY));
//            this.vfxTimer = MathUtils.random(this.vfxIntervalMin, this.vfxIntervalMax);
//        }

    }

    public void render(SpriteBatch sb) {
        if (this.img != null) {
            sb.setColor(this.c);
            sb.draw(this.img, this.cX - (float)this.img.getWidth() / 2.0F + this.bobEffect.y / 4.0F, this.cY - (float)this.img.getHeight() / 2.0F + this.bobEffect.y / 4.0F, (float)this.img.getWidth() / 2.0F, (float)this.img.getHeight() / 2.0F, (float)this.img.getWidth(), (float)this.img.getHeight(), this.scale, this.scale, 0.0F, 0, 0, this.img.getWidth(), this.img.getHeight(), false, false);
        }

        this.renderText(sb);
        this.hb.render(sb);
    }

    protected void renderText(SpriteBatch sb) {
//        if (this.showEvokeValue) {
//            FontHelper.renderFontCentered(sb, FontHelper.cardEnergyFont_L, Integer.toString(this.evokeAmount), this.cX + NUM_X_OFFSET, this.cY + this.bobEffect.y / 2.0F + NUM_Y_OFFSET - 4.0F * Settings.scale, new Color(0.2F, 1.0F, 1.0F, this.c.a), this.fontScale);
//        }
    }

    public void playChannelSFX() {
//        CardCrawlGame.sound.play("ORB_PLASMA_CHANNEL", 0.1F);
    }

    public AbstractOrb makeCopy() {
        return new PptpDetective();
    }

    static {
        orbString = CardCrawlGame.languagePack.getOrbString(ORB_ID);
        DESC = orbString.DESCRIPTION;
    }

}
