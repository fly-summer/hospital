package action;

import java.util.List;

import model.Recipe;
import model.Recipe;

public interface RecipeDao {
	public Recipe queryRecipeByRId(int RId);//�鿴ָ��RId����Ϣ
	
	//����Recipe��¼
	public boolean saveRecipe(Recipe recipe);
	
	
	//����Recipe��¼
	public boolean updateRecipe(String Re,int RId);
	
	public List<Recipe>queryAllByDName(String DName);//��ѯָ��ҽ�������¼
	public List<Recipe>queryAllBySName(String SName);//��ѯָ�����߾����¼
	

}
