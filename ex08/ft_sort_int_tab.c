/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_sort_int_tab.c                                  :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: seunghel <seunghel@student.42seoul.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/08/29 16:19:29 by seunghel          #+#    #+#             */
/*   Updated: 2022/08/30 12:43:04 by seunghel         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <unistd.h>

void	ft_sort_int_tab(int *tab, int size)
{
	int	i;
	int	j;
	int	temp;

	i = 1;
	while (i < size)
	{
		temp = tab[i];
		j = i -1;
		while (j >= 0 && tab[j] > temp)
		{
			tab[j + 1] = tab[j];
			j--;
		}
		tab[j + 1] = temp;
		i++;
	}
}
