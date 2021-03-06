package pe.comercio.material_searchable_view;

import android.util.Log;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Carlos Vargas on 11/25/16.
 * CarlitosDroid
 */

public class UserFilter extends Filter {
    private List<UserEntity> userEntityList;
    private List<UserEntity> filteredUserEntityList;
    private UserAdapter adapter;

    UserFilter(List<UserEntity> userEntityList, UserAdapter adapter) {
        super();
        this.userEntityList = new LinkedList<>(userEntityList);
        this.adapter = adapter;
        this.filteredUserEntityList = new ArrayList<>();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        //here you need to add proper items do filteredUserEntityList
        Log.e("charsequence","charsequence "  + constraint);
        filteredUserEntityList.clear();
        final FilterResults results = new FilterResults();

        if (constraint.length() == 0) {
            filteredUserEntityList.addAll(userEntityList);
        } else {
            final String filterPattern = constraint.toString().toLowerCase().trim();

            for (final UserEntity userEntity : userEntityList) {
                if (userEntity.getName().contains(filterPattern)) {
                    filteredUserEntityList.add(userEntity);
                }
            }
        }
        results.values = filteredUserEntityList;
        results.count = filteredUserEntityList.size();
        return results;

    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.getFilteredList().clear();
        adapter.getFilteredList().addAll((ArrayList<UserEntity>) results.values);
        adapter.notifyDataSetChanged();
    }
}
