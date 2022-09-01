/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ft_print_combn.c                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: seunghel <seunghel@student.42seoul.kr>     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/08/28 20:46:18 by seunghel          #+#    #+#             */
/*   Updated: 2022/08/29 22:54:18 by seunghel         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <unistd.h>
#include <stdio.h>

void ft_putchar(char c, char n)
{
	write(1, &c, n);
}

void recursive(int i, int n, char *arr)
{
	char *a;

	i
	if (i == n)
		a[i] = 0;
	else
	{
		a[i] = a[i -1] + 1;
		while(i < n)
		{
			if (a[i] == arr[i])
				ft_putchar(a[i]);
			else
				recursive(i + 1, n, arr);
			i++;
		}
	}
}

void ft_print_combn(int n)
{
	char front;
	char end;

	front = '0';
	end = '0';
	idx = 0;

	if(end == '9')
		ft_act_combn(front + 1, end + 1);
	else
		ft_act_combn(front, end + 1);
	idx++;
}

int main(void)
{
	ft_print_combn(2);
}
