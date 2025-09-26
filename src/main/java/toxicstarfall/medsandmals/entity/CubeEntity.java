package toxicstarfall.medsandmals.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CubeEntity extends PathAwareEntity {
 
    public CubeEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

    public Identifier getTexture(CubeEntity entity) {
        return Identifier.of("entitytesting", "textures/entity/cube/cube.png");
    }
}