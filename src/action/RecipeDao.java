package action;

import java.util.List;

import model.Recipe;
import model.Recipe;

public interface RecipeDao {
	public Recipe queryRecipeByRId(int RId);//查看指定RId的信息
	
	//保存Recipe记录
	public boolean saveRecipe(Recipe recipe);
	
	
	//更新Recipe记录
	public boolean updateRecipe(String Re,int RId);
	
	public List<Recipe>queryAllByDName(String DName);//查询指定医生就诊记录
	public List<Recipe>queryAllBySName(String SName);//查询指定患者就诊记录
	

}
