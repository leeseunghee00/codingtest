/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_putnbr.c                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: seunghel <seunghel@student.42seoul.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/08/25 16:22:19 by seunghel          #+#    #+#             */
/*   Updated: 2022/08/30 15:51:13 by seunghel         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdio.h>
#include <direct.h>

void	ft_putchar(char n)
{
	write(1, &n, 1);
}

void	ft_putnbr(int nb)
{
	if (nb < 0)
	{
		write(1, "-", 1);
		if (nb == -2147483648)
		{
			write(1, "2147483648", 10);
			return ;
		}
		ft_putnbr(-nb);
	}
	else if (nb < 10)
	{	
		ft_putchar(nb + 48);
	}
	else
	{
		ft_putnbr(nb / 10);
		nb %= 10;
		ft_putchar(nb + 48);
	}
}

int	main(void)
{
	ft_putnbr(-2147483648);
	return (0);
}
