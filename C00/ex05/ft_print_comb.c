/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_print_comb.c                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: seunghel <seunghel@student.42seoul.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/08/27 21:42:35 by seunghel          #+#    #+#             */
/*   Updated: 2022/08/28 22:25:38 by seunghel         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <unistd.h>
#include <stdio.h>

void	ft_print_comb(void)
{
	char	num[3];
	char	comb[2];

	num[0] = '0';
	comb[0] = ',';
	comb[1] = ' ';
	while (num[0] <= '7')
	{
		num[1] = num[0] + 1;
		while (num[1] <= '8')
		{
			num[2] = num[1] + 1;
			while (num[2] <= '9')
			{
				write(1, num, 3);
				if (num[0] != '7' || num[1] != '8' || num[2] != '9')
				{
					write(1, comb, 2);
				}
				num[2]++;
			}
			num[1]++;
		}
		num[0]++;
	}
}

int	main(void)
{
	ft_print_comb();
}}
