package com.floward.floward_task.core.ui.bottomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person

sealed class BottomNavItem(val route: String, val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    data object Dashboard : BottomNavItem("dashboard", "Dashboard", Icons.Default.Home)
    data object Profile : BottomNavItem("profile", "Profile", Icons.Default.Person)
}