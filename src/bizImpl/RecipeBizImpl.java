package bizImpl;

import java.util.List;

import action.RecipeDao;
import action.impl.RecipeDaoImpl;
import action.impl.SickDaoImpl;
import biz.RecipeBiz;
import model.Recipe;

public class RecipeBizImpl implements RecipeBiz {
	private RecipeDao recipeDao=null;
		public RecipeBizImpl() {
		
		recipeDao=new RecipeDaoImpl();
	}
	@Override
	public boolean saveRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return recipeDao.saveRecipe(recipe);
	}
	
	@Override
	public Recipe queryRecipeByRId(int RId) {
		// TODO Auto-generated method stub
		return recipeDao.queryRecipeByRId(RId);
	}




	@Override
	public boolean updateRecipe(String Re,int RId) {
		// TODO Auto-generated method stub
		return recipeDao.updateRecipe(Re,RId);
	}

	@Override
	public List<Recipe> queryAllByDName(String DName) {
		// TODO Auto-generated method stub
		return recipeDao.queryAllByDName(DName);
	}

	@Override
	public List<Recipe> queryAllBySName(String SName) {
		// TODO Auto-generated method stub
		return recipeDao.queryAllBySName(SName);
	}

}
