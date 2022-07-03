package binary_search.leet_code_33;

/**
 * @author : dev
 * @version :
 * @Date :  4/27/21 10:06 PM
 * @Desc : 33 搜索旋转排序数组：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/
 * <p>
 * 二分查找的变型，考察一下二分查找
 * <p>
 * 题解：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/
 * <p>
 * 可以再看看：153，1095，852；
 *
 * 一姐：https://www.youtube.com/watch?v=IQyJX5ddEx0
 */
public class Search {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (target == nums[mid]) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[low] 的关系，判断 mid 是在左段还在右段
            if (nums[mid] >= nums[low]) {
                //再判断 target 是在 mid 的左边还是在右边，从而调整左右边界 low 和 high
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public int search3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }

    public int search4(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }
        }

        return -1;


    }

    public int search5(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }


            if (nums[mid] >= nums[low]) {
                if (target > nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return -1;


    }

    public int search6(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }

        return -1;


    }

    public int search7(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid - 1;
                }
            } else {
                if (target > nums[mid] && target >= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;


    }

    public int search8(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }


        }

        return -1;


    }

    /**
     * 搜索旋转数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int search9(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public int search10(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            } else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }

            }

        }
        return -1;

    }

    /**
     * nums = [4,5,6,7,0,1,2]
     * 1:首先根据 nums[0] 与 target 的关系判断 target 是在左段还是在右段
     * 2： 假如 target = 5 目标值在左半段，因此在[4, 5, 6, 7, inf, inf, inf] 这个有序数组里查找
     * 3： 假如 target = 1, 目标值在右半段，因此在[-inf, -inf, -inf, -inf, 0, 1, 2]，这个有序数组里查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search11(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 先根据 nums[0] 与 target 的关系判断目标值在左半段 还是在右半段
            if (target >= nums[0]) {
                // 左半段
                // 目标值在左半段，若 mid 在 右半段，则将 mid 索引的值改为 inf；
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }

            } else {
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }


            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }

    public int search12(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target > nums[0]) {
                // 目标值在左半段，但是 mid 值落在了右半段；
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }

            } else {
                // 目标值在右半段，但是 mid 留在了左半段
                if (nums[mid] > nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;

    }

    public int search13(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;

            if (target >= nums[0]) {
                // 在左边
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }
            } else {
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return -1;
    }

    public int search14(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target >= nums[0]) {
                if (nums[mid] < nums[0]) {
                    nums[mid] = Integer.MAX_VALUE;
                }

            } else {
                if (nums[mid] >= nums[0]) {
                    nums[mid] = Integer.MIN_VALUE;
                }
            }

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }


}
