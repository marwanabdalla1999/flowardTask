package com.floward.floward_task.core.ui.bottomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import com.floward.floward_task.core.ui.navigations.DashboardDestination
import com.floward.floward_task.core.ui.navigations.Destination
import com.floward.floward_task.core.ui.navigations.ProfileDestination

sealed class BottomNavItem(val destination: Destination, val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    data object Dashboard : BottomNavItem(DashboardDestination, "Dashboard", Icons.Default.Home)
    data object Profile : BottomNavItem(ProfileDestination(), "Profile", Icons.Default.Person)
}