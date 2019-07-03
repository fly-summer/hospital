package action.impl;

import java.util.ArrayList;
import java.util.List;

import action.RecipeDao;
import model.Recipe;
import model.Recipe;
import model.Sick;

public class RecipeDaoImpl extends BaseDao implements RecipeDao {

	@Override
	public Recipe queryRecipeByRId(int RId) {
		List<Recipe> qList=null;
		String sql="select RId,DName,SName,Re where RId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(RId);
		try {
			qList=this.operQuery(sql, params, Recipe.class);
		} catch (Exception e) {

			e.printStackTrace();
		}
		if(qList.size()>0){
			return qList.get(0);
		}
		
		return null;
	}

	@Override
	public boolean saveRecipe(Recipe recipe) {
		String sql="insert into recipe(RId,DName,SName) values(?,?,?)";;
		List<Object> params=new ArrayList<Object>();
		params.add(recipe.getRId());
		params.add(recipe.getDName());
		params.add(recipe.getSName());
//		params.add(recipe.getRe());
		return this.operUpdate(sql, params);
	}

	@Override
	public boolean updateRecipe(String Re,int RId) {
		String sql="update recipe set Re=? where RId=?";
		List<Object> params=new ArrayList<Object>();
		params.add(Re);
		params.add(RId);
		return this.operUpdate(sql, params);
	
	}

	@Override
	public List<Recipe> queryAllByDName(String DName) {
		List<Recipe> data=null;
		String sql="select RId,DName,SName,Re from recipe where DName=?";
		List<Object> params=new ArrayList<Object>();
		params.add(DName);
		try {
			data=this.operQuery(sql, params,Recipe.class );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Recipe> queryAllBySName(String SName) {
		// TODO Auto-generated method stub
		List<Recipe> data=null;
		String sql="select RId,DName,SName,Re from recipe where SName=?";
		List<Object> params=new ArrayList<Object>();
		params.add(SName);
		try {
			data=this.operQuery(sql, params,Recipe.class );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	
	}

}
