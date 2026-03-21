import java.util.List;

public class BasicAttack implements Action {
    @Override
    public void execute(Combatant source, List<Combatant> targets) {
        if (source == null || targets == null || targets.isEmpty()) {
            return;
        }
        
        int attackerATK = source.getAttack();
        
        for (Combatant target : targets) {
            if (target == null || !target.isAlive()) {
                //for multi-attacks, still need to process attack on other enemies
                continue;
            }
            
            int targetDEF = target.getDefense();
            //formula for damage
            int damage = Math.max(0, attackerATK - targetDEF);
            
            target.takeDamage(damage);
        }
    }
}
