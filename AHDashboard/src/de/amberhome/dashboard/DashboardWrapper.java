// Version History
// 
// 1.02
//   - Optimized layout engine

package de.amberhome.dashboard;

import android.view.View;
import android.view.ViewGroup;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.ConcreteViewWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;

@Version(1.02f)
@Author("Markus Stipp")

@BA.ActivityObject
@BA.ShortName("AHDashboard")
/**
 * The AHDashboard object acts like a Panel object. The objects added
 * to the AHDashboard are evenly distributed horizontally and vertically
 * so that they are arranged in a grid.
 */
public class DashboardWrapper extends ViewWrapper<ViewGroup>
{
	/**
	 * This library provides a special layout object like a Panel. The items
	 * added to the AHDashboard object are evenly distributed horizontally and
	 * vertically. 
	 * 
	 * This object inherits all methods from a standard B4A view but the
	 * documentation can not be inherited from it. So for some methods the
	 * documentation is missing. Please refer to a standard B4A View for a 
	 * complete explanation.
	 */
	public static void LIBRARY_DOC() {

	}

	@BA.Hide
	public void innerInitialize(BA ba, String eventName, boolean keepOldObject)
	{
		if (!keepOldObject)
			setObject(new DashboardLayout(ba.context));
		super.innerInitialize(ba, eventName, true);
	}

	/**
	 * Add a view to the dashboard
	 * 
	 * There are no parameters for top or left since the
	 * view is positioned automatically.
	 * 
	 * View - The View to add
	 * Width - The width of the view to add
	 * Height - The height of the view to add
	 */
	public void AddView(View View, int Width, int Height)
	{
		((ViewGroup)getObject()).addView(View, Width, Height);
	}

	/**
	 * Get the view at the specified index.
	 * 
	 * Index - The index of the view to get.
	 */
	public ConcreteViewWrapper GetView(int Index)
	{
		ConcreteViewWrapper c = new ConcreteViewWrapper();
		c.setObject(((ViewGroup)getObject()).getChildAt(Index));
		return c;
	}

	/**
	 * Remove the specified view from the AHDashboard
	 * 
	 * Index - Index of the view to be removed.
	 */
	public void RemoveViewAt(int Index)
	{
		((ViewGroup)getObject()).removeViewAt(Index);
	}

	/**
	 * Gets the number of views on the Dashboard.
	 */
	public int getNumberOfViews()
	{
		return ((ViewGroup)getObject()).getChildCount();
	}
}
