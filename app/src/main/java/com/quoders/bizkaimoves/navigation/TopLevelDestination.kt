package com.quoders.bizkaimoves.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.DirectionsBus
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.DirectionsBus
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.ui.graphics.vector.ImageVector
import com.quoders.bizkaimoves.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    AROUND_ME(
        selectedIcon = Icons.Rounded.Explore,
        unselectedIcon = Icons.Outlined.Explore,
        iconTextId = R.string.around_me_menu,
        titleTextId = R.string.around_me_menu,
    ),
    LINES(
        selectedIcon = Icons.Rounded.DirectionsBus,
        unselectedIcon = Icons.Outlined.DirectionsBus,
        iconTextId = R.string.lines_menu,
        titleTextId = R.string.lines_menu,
    ),
    FAVORITES(
        selectedIcon = Icons.Rounded.Bookmark,
        unselectedIcon = Icons.Outlined.Bookmarks,
        iconTextId = R.string.favorites_menu,
        titleTextId = R.string.favorites_menu,
    ),
}