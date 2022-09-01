/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_print_comb2.c                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: seunghel <seunghel@student.42seoul.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/08/25 13:01:07 by seunghel          #+#    #+#             */
/*   Updated: 2022/08/28 15:27:21 by seunghel         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>
#include <unistd.h>

void	ft_putchar(char *fp, char *sp)
{
	write(1, fp, 2);
	write(1, " ", 1);
	write(1, sp, 2);
}

void	ft_print_comb2(void)
{
	char	fp[2];
	char	sp[2];
	int	i;
	int	j;

	i = 0;
	while (i < 99)
	{
		fp[0] = i / 10 + '0';
		fp[1] = i % 10 + '0';
		j = i + 1;
		while (j < 100)
		{
			sp[0] = j / 10 + '0';
			sp[1] = j % 10 + '0';
			ft_putchar(fp, sp);
			if (!(fp[0] == '9' && fp[1] == '8'))
			{
				write(1, ", ", 2);
			}
			j++;
		}
		i++;
	}
}

int	main(void)
{
	ft_print_comb2();
}
