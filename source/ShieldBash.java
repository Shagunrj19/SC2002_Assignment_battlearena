import java.util.List;

public class ShieldBash implements Action {
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        if (source == null || targets == null || targets.isEmpty()) {
            return;
        }
        
        // Deal damage 
        Combatant target = targets.get(0);
        if (target != null && target.isAlive()) {
            int attackerATK = source.getAttack();
            int targetDEF = target.getDefense();
            //damage formula
            int damage = Math.max(0, attackerATK - targetDEF);
            
            target.takeDamage(damage);
            
            // Stun target for 2 rounds if alive
            if (target.isAlive()) {
                StunEffect stun = new StunEffect();
                target.addStatusEffect(stun);
            }
        }
    }
}
